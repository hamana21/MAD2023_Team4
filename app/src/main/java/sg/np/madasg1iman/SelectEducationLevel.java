package sg.np.madasg1iman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.madasg1iman.R;

public class SelectEducationLevel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecteducationlevel);

        Button primaryButton = findViewById(R.id.primarySchBtn);
        primaryButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SelectEducationLevel.this, PrimarySchool.class);
                startActivity(intent);
            }
        });
    }
}