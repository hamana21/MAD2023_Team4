package sg.np.madasg1iman;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.madasg1iman.R;

public class AboutMe extends AppCompatActivity {

    private TextView bioTextView;
    private EditText emailEditText;
    private Button subscribeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutme);

        bioTextView = findViewById(R.id.bioTextView);
        emailEditText = findViewById(R.id.emailEditText);
        subscribeButton = findViewById(R.id.subscribeButton);

        String bio = "Welcome to Educademy! 🎓\n\n"
                + "We are passionate about empowering students to excel in their exams and achieve academic success. As the team behind Educademy, our goal is to provide a comprehensive platform that helps students practice for their tests effectively.\n\n"
                + "With Educademy, students can access a wide range of quizzes and video tutorials that cover various subjects and topics. Our carefully curated quizzes are designed to test and strengthen students' knowledge, while the video tutorials provide in-depth explanations and guidance.\n\n"
                + "We believe that practice and understanding are the keys to mastering any subject. Through Educademy, we aim to support students in their learning journey by offering a convenient and interactive platform that fosters learning and growth.\n\n"
                + "Join us today and embark on a rewarding educational experience with Educademy. Start practicing, enhancing your skills, and achieving your academic goals!\n";

//        bioTextView.setText(bio);

        subscribeButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            if (isValidEmail(email)) {
                // Perform the subscription logic here
                // You can send the email to your server or perform other actions

                Toast.makeText(AboutMe.this, "Subscribed to newsletter!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(AboutMe.this, "Invalid email address", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isValidEmail(CharSequence target) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
