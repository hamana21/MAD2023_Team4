package com.example.madasg1iman;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class P6SA2Math extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;
    TextView questiontextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    int score = 0;
    int totalQuestion = MathQuestionAnswer.Mathquestion.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa2maths);

        totalQuestionsTextView = findViewById(R.id.total_question);
        questiontextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total Questions: "+totalQuestion);

        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE );
        ansB.setBackgroundColor(Color.WHITE );
        ansC.setBackgroundColor(Color.WHITE );
        ansD.setBackgroundColor(Color.WHITE );

        Button clickedButton = (Button) view;

        if(clickedButton.getId()==R.id.submit_btn){

            if(selectedAnswer.equals(MathQuestionAnswer.matchCorrectAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();
        }else{
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }
        questiontextView.setText(MathQuestionAnswer.Mathquestion[currentQuestionIndex]);
        ansA.setText(MathQuestionAnswer.mathChoices[currentQuestionIndex][0]);
        ansB.setText(MathQuestionAnswer.mathChoices[currentQuestionIndex][1]);
        ansC.setText(MathQuestionAnswer.mathChoices[currentQuestionIndex][2]);
        ansD.setText(MathQuestionAnswer.mathChoices[currentQuestionIndex][3]);
    }

    void finishQuiz(){
        String passStatus = "";

        if(score > totalQuestion*0.60){
            passStatus="Passed";
        }else{
            passStatus="Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Your mark is "+score+" out of "+ totalQuestion)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();

    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }
}