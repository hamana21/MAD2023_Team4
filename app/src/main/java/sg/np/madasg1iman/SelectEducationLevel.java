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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_education_level);
        primaryButton = findViewById(R.id.primarySchBtn);
        secondaryButton = findViewById(R.id.secondarySchBtn);

        primaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPrimaryMcq();
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