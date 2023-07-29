package sg.np.madasg1iman;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.madasg1iman.R;

public class primaryStartingPage extends AppCompatActivity {
    public static final int PRI_REQUEST_CODE_QUIZ = 1;
    public static final String EXTRA_PRIMARY_LEVEL = "extraPrimaryLevel";
    public static final String EXTRA_PRIMARY_SUBJECT = "extraPrimarySubject";

    public static final String PRI_SHARED_PREFS = "priSharedPrefs";
    public static final String PRI_KEY_HIGHSCORE = "priKeyHighscore";

    private TextView textViewHighscore;
    private Spinner spinnerPrimaryLevel;
    private Spinner spinnerPrimarySubject;
    private int highscore;
    private Button startQuiz;
    private Button backBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_starting_page);

        textViewHighscore = findViewById(R.id.textViewHighscore);
        spinnerPrimaryLevel = findViewById(R.id.spinnerPrimaryLevel);
        spinnerPrimarySubject = findViewById(R.id.spinnerPrimarySubject);

        String[] primaryLevels = primaryQuestion.getAllPrimaryLevels();
        String[] primarySubjects = primaryQuestion.getAllPrimarySubjects();


        ArrayAdapter<String> adapterPriLevels = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, primaryLevels);
        adapterPriLevels.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPrimaryLevel.setAdapter(adapterPriLevels);

        ArrayAdapter<String> adpterPriSubjects = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, primarySubjects);
        adpterPriSubjects.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPrimarySubject.setAdapter(adpterPriSubjects);

        loadHighscore();

        startQuiz = findViewById(R.id.buttonStartQuiz);
        backBtn = findViewById(R.id.buttonBack);
        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });
    }

    private void startQuiz() {
        String primaryLevel = spinnerPrimaryLevel.getSelectedItem().toString();
        String primarySubject = spinnerPrimarySubject.getSelectedItem().toString();

        Intent intent = new Intent(primaryStartingPage.this, primaryQuiz.class);
        intent.putExtra(EXTRA_PRIMARY_LEVEL, primaryLevel);
        intent.putExtra(EXTRA_PRIMARY_SUBJECT, primarySubject);
        startActivityForResult(intent, PRI_REQUEST_CODE_QUIZ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PRI_REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK){
                int score = data.getIntExtra(primaryQuiz.PRI_EXTRA_SCORE, 0);
                if (score > highscore){
                    updateHighscore(score);
                }
            }
        }
    }

    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(PRI_SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(PRI_KEY_HIGHSCORE, 0);
        textViewHighscore.setText("Highscore: " + highscore);
    }

    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        textViewHighscore.setText("Highscore: " + highscore);

        SharedPreferences prefs = getSharedPreferences(PRI_SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(PRI_KEY_HIGHSCORE, highscore);
        editor.apply();
    }

    private void back() {
        Intent intent = new Intent(primaryStartingPage.this, SelectEducationLevel.class);
        startActivity(intent);
    }
}