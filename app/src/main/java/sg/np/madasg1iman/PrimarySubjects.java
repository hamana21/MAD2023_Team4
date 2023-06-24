package sg.np.madasg1iman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.madasg1iman.R;

public class PrimarySubjects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primarysubjects);
        Button primarySubject = findViewById(R.id.primarysubject1);
        Button primarySubject2 = findViewById(R.id.primarysubject);

        primarySubject.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrimarySubjects.this, P6SA2Eng.class);
                startActivity(intent);
            }
        });

        primarySubject2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrimarySubjects.this, P6SA2Math.class);
                startActivity(intent);
            }
        });
    }
}