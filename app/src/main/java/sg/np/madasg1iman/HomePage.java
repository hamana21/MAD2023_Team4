package sg.np.madasg1iman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.madasg1iman.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class HomePage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    AboutFragment aboutFragment = new AboutFragment();
    AccountFragment accountFragment = new AccountFragment();

    private ImageButton papers_btn, online_btn, account_btn, about_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        papers_btn = findViewById(R.id.imageButton6);
        online_btn = findViewById(R.id.imageButton7);
        account_btn = findViewById(R.id.imageButton4);
        about_btn = findViewById(R.id.imageButton5);
        //logoutbtn = findViewById(R.id.logout)


        buttonEvents();

        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                } else if (id == R.id.info) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, aboutFragment).commit();
                } else if (id == R.id.account) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, accountFragment).commit();
                }
                return true;
            }
        });
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
                startActivity(new Intent(HomePage.this, ContactUsActivity.class));
            }
        });

        /*logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, LoginActivity.class));
            }
        });*/
    }
}