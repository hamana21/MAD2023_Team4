package com.example.madasg1iman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomePage extends AppCompatActivity {

    private ImageButton papers_btn, online_btn, account_btn, about_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        papers_btn = findViewById(R.id.imageButton6);
        online_btn = findViewById(R.id.imageButton7);
        account_btn = findViewById(R.id.imageButton4);
        about_btn = findViewById(R.id.imageButton5);
        buttonEvents();
    }
    private void buttonEvents(){
        papers_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, HomePage.class);
                startActivity(intent);
            }
        });
    }
}