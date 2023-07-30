package sg.np.madasg1iman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madasg1iman.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class primaryQuiz extends AppCompatActivity {
    public static final String PRI_EXTRA_SCORE = "priExtraScore";
    private static final long COUNTDOWN_IN_MILLIS = 61000;

    private static final String PRI_KEY_SCORE = "priKeyScore";
    private static final String PRI_KEY_QUESTION_COUNT = "prikeyQuestionCount";
    private static final String PRI_KEY_MILLIS_LEFT = "prikeyMillisLeft";
    private static final String PRI_KEY_ANSWERED = "prikeyAnswered";
    private static final String PRI_KEY_QUESTION_LIST = "prikeyQuestionList";
    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewPrimaryLevel;
    private TextView textViewPrimarySubject;
    private TextView textViewCountdown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button buttonConfirmNext;

    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private ArrayList<primaryQuestion> priQuestionList;
    private int questionCounter;
    private int questionCountTotal;
    private primaryQuestion currentQuestion;

    private int score;
    private boolean answered;

    private long backPressedTime;

    public primaryQuiz() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_quiz);

        textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewScore = findViewById(R.id.textViewScore);
        textViewQuestionCount = findViewById(R.id.textViewQuestionCount);
        textViewPrimaryLevel = findViewById(R.id.textViewPrimaryLevel);
        textViewPrimarySubject = findViewById(R.id.textViewPrimarySubject);
        textViewCountdown = findViewById(R.id.textViewCountdown);
        rbGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.radioButton1);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);
        buttonConfirmNext = findViewById(R.id.buttonConfirmNext);

        textColorDefaultRb = rb1.getTextColors();
        textColorDefaultCd = textViewCountdown.getTextColors();

        Intent intent = getIntent();
        String primaryLevel = intent.getStringExtra(primaryStartingPage.EXTRA_PRIMARY_LEVEL);
        String primarySubject = intent.getStringExtra(primaryStartingPage.EXTRA_PRIMARY_SUBJECT);

        textViewPrimaryLevel.setText("" + primaryLevel);
        textViewPrimarySubject.setText("Subject: " + primarySubject);

        if (savedInstanceState == null) {
            primaryQuizDbHelper priDbHelper = new primaryQuizDbHelper(this);
            priQuestionList = priDbHelper.getPrimaryQuestions(primaryLevel, primarySubject);
            questionCountTotal = priQuestionList.size();
            Collections.shuffle(priQuestionList);

            showNextQuestion();
        }else {
            priQuestionList = savedInstanceState.getParcelableArrayList(PRI_KEY_QUESTION_LIST);
            questionCountTotal = priQuestionList.size();
            questionCounter = savedInstanceState.getInt(PRI_KEY_QUESTION_COUNT);
            currentQuestion = priQuestionList.get(questionCounter - 1);
            score = savedInstanceState.getInt(PRI_KEY_SCORE);
            timeLeftInMillis = savedInstanceState.getLong(PRI_KEY_MILLIS_LEFT);
            answered = savedInstanceState.getBoolean(PRI_KEY_ANSWERED);

            if (!answered){
                startCountDown();
            }else{
                updateCountDownText();
                showSolution();
            }

        }

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {
                        checkAnswer();
                    }else {
                        Toast.makeText(primaryQuiz.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rb4.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();

        if (questionCounter < questionCountTotal) {
            currentQuestion = priQuestionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getPriQuestion());
            rb1.setText(currentQuestion.getPriOption1());
            rb2.setText(currentQuestion.getPriOption2());
            rb3.setText(currentQuestion.getPriOption3());
            rb4.setText(currentQuestion.getPriOption4());

            questionCounter++;
            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            buttonConfirmNext.setText("Confirm");

            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();
        }else {
            finishQuiz();
        }
    }

    private void startCountDown () {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountdown.setText(timeFormatted);

        if (timeLeftInMillis < 10000){
            textViewCountdown.setTextColor(Color.RED);
        }else{
            textViewCountdown.setTextColor(textColorDefaultCd);
        }
    }

    private void checkAnswer() {
        answered = true;

        countDownTimer.cancel();

        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestion.getPriAnswerNum()){
            score++;
            textViewScore.setText("Score: " + score);
        }

        showSolution();
    }

    private void showSolution(){
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);

        switch (currentQuestion.getPriAnswerNum()) {
            case 1:
                rb1.setTextColor(Color.GREEN);
                textViewQuestion.setText("Option 1 is correct answer");
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                textViewQuestion.setText("Option 2 is correct answer");
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                textViewQuestion.setText("Option 3 is correct answer");
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                textViewQuestion.setText("Option 4 is correct answer");
                break;
        }

        if (questionCounter < questionCountTotal) {
            buttonConfirmNext.setText("Next");
        } else {
            buttonConfirmNext.setText("Finish");
        }
    }

    private void finishQuiz() {
        Intent resultIntent =new Intent();
        resultIntent.putExtra(PRI_EXTRA_SCORE, score);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            finishQuiz();
        }else{
            Toast.makeText(this, "Press Back again to finish", Toast.LENGTH_SHORT).show();

        }

        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null){
            countDownTimer.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(PRI_KEY_SCORE, score);
        outState.putInt(PRI_KEY_QUESTION_COUNT, questionCounter);
        outState.putLong(PRI_KEY_MILLIS_LEFT, timeLeftInMillis);
        outState.putBoolean(PRI_KEY_ANSWERED, answered);
        outState.putParcelableArrayList(PRI_KEY_QUESTION_LIST, priQuestionList);
    }
}