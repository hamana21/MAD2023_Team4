package com.example.madasg1iman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomePage extends AppCompatActivity {

    private ImageButton papers_btn, online_btn, account_btn, about_btn,imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        papers_btn = findViewById(R.id.imageButton6);
        online_btn = findViewById(R.id.imageButton7);
        account_btn = findViewById(R.id.imageButton4);
        about_btn = findViewById(R.id.imageButton5);
        imageButton = findViewById(R.id.imageButton);
        buttonEvents();
    }
    private void buttonEvents(){
        papers_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, HomePage.class));
            }
        });

        about_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, AboutMe.class));
            }
        });

        papers_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, HomePage.class));
            }
        });

        papers_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, HomePage.class));
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear all activities
                Intent intent = new Intent(HomePage.this, HomePage.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}