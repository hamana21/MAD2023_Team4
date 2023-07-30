package sg.np.madasg1iman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.madasg1iman.R;

public class SelectEducationLevel extends AppCompatActivity {
    private Button primaryButton;
    private Button secondaryButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_education_level);
        primaryButton = findViewById(R.id.primarySchBtn);
        secondaryButton = findViewById(R.id.secondarySchBtn);
        backButton = findViewById(R.id.btn_back);

        primaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPrimaryMcq();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectEducationLevel.this, HomePage.class);
                startActivity(intent);
            }
        });

       /* secondaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSecondaryMcq();
            }
        });*/
    }

    private void startPrimaryMcq() {
        Intent intent = new Intent(SelectEducationLevel.this, primaryStartingPage.class);
        startActivity(intent);
    }

    /*private void startSecondaryMcq() {
        Intent intent = new Intent(SelectEducationLevel.this, secondaryStartingPage.class);
        startActivity(intent);
    }*/
}