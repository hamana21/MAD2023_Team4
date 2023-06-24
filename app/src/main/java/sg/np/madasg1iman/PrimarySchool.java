package sg.np.madasg1iman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.madasg1iman.R;

public class PrimarySchool extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pri);
        Button primary6 = findViewById(R.id.pri18);

        primary6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrimarySchool.this, PrimarySubjects.class);
                startActivity(intent);
            }
        });
    }
}