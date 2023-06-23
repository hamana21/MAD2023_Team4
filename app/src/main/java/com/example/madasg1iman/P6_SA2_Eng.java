package sg.edu.np.mad.madassg1mcqv2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestions;
    TextView question;
    Button ansA, ansB, ansC, ansD;
    Button submitButton;

    int score=0;
    int totalQuestion = QnA_Eng.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalQuestions = findViewById(R.id.total_question);
        question = findViewById(R.id.question);
        ansA = findViewById(R.id.option_A);
        ansB = findViewById(R.id.option_B);
        ansC = findViewById(R.id.option_C);
        ansD = findViewById(R.id.option_D);
        submitButton = findViewById(R.id.submit_button);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitButton.setOnClickListener(this);

        totalQuestions.setText("Total questions" + totalQuestion);

        loadNewQuestion();
    }

    @Override
    public void onClick(View v) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) v;
        if (clickedButton.getId()==R.id.submit_button){
            if (selectedAnswer.equals(QnA_Eng.corectAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();


        }else{
            //option button is click
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }

    }

    void loadNewQuestion(){

        if (currentQuestionIndex == totalQuestion){
            finishMCQ();
            return;
        }
        question.setText(QnA_Eng.question[currentQuestionIndex]);
        ansA.setText(QnA_Eng.options[currentQuestionIndex][0]);
        ansB.setText(QnA_Eng.options[currentQuestionIndex][1]);
        ansC.setText(QnA_Eng.options[currentQuestionIndex][2]);
        ansD.setText(QnA_Eng.options[currentQuestionIndex][3]);

    }

    void finishMCQ(){
        String passStatus = "";
        if (score > totalQuestion * 0.60) {
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is "+ score+ " out of " + totalQuestion)
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();

    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();


    }
}