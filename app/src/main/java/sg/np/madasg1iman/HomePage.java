package sg.np.madasg1iman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.madasg1iman.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomePage extends AppCompatActivity {

    private CircleImageView profilepic;
    private ImageButton papers_btn, online_btn, account_btn, about_btn, imageButton, btmAboutButton, btmAccountBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        papers_btn = findViewById(R.id.imageButton6);
        online_btn = findViewById(R.id.imageButton7);
        account_btn = findViewById(R.id.imageButton4);
        about_btn = findViewById(R.id.imageButton5);
        imageButton = findViewById(R.id.imageButton);
        btmAboutButton = findViewById(R.id.btmAboutImg);
        btmAccountBtn = findViewById(R.id.btmAccountBtn);
        profilepic = findViewById(R.id.imageView4);
        //logoutbtn = findViewById(R.id.logout)
        buttonEvents();
    }
    private void buttonEvents(){

        about_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, AboutMe.class));
            }
        });

        papers_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, SelectEducationLevel.class));
            }
        });

        online_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, VideosPage.class));
            }
        });

        account_btn.setOnClickListener(new View.OnClickListener() {
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

        btmAboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear all activities
                Intent intent = new Intent(HomePage.this, AboutMe.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btmAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear all activities
                Intent intent = new Intent(HomePage.this, HomePage.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


        btmAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear all activities
                Intent intent = new Intent(HomePage.this, LoginActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(HomePage.this, "You have logged out!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        profilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("I LOVE THIS MODULE MORE", "I LOVE THIS MODULE");
                Intent intent = new Intent(HomePage.this, AboutMe.class);
                startActivity(intent);
                finish();
            }
        });

    }
}