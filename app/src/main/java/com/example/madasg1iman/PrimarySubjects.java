package com.example.madasg1iman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PrimarySubjects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primarysubjects);
        Button primarySubject = findViewById(R.id.primarysubject1);

        primarySubject.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrimarySubjects.this, P6SA2Eng.class);
                startActivity(intent);
            }
        });
    }
}