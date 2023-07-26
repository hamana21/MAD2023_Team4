package sg.np.madasg1iman;

import static android.provider.MediaStore.MediaColumns.TITLE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.madasg1iman.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText userinput, passwordinput;
    private Button loginbutton;
    private TextView registerbutton;

    FirebaseAuth mAuth;

    public void onStart(){
        super.onStart();
        FirebaseUser currentuser = mAuth.getCurrentUser();
        if(currentuser != null){
            Intent intent = new Intent(LoginActivity.this, HomePage.class);
            startActivity(intent);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.v(TITLE, "CREATE!");
        initView();

        setVariable();

    }
    private void setVariable(){
        loginbutton.setOnClickListener(v -> {
            /*String loginuser = userinput.getText().toString();
            String loginpass = passwordinput.getText().toString();
            String registereduser = preferences.getString(KEY_NAME,"");
            String registeredpass = preferences.getString(KEY_PASS,"");
            if (loginuser.equals(registereduser)&& loginpass.equals(registeredpass)){
                Toast.makeText(LoginActivity.this, "Log In Successful!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, HomePage.class);
                startActivity(intent);
            }
            else if (userinput.getText().toString().isEmpty()){
                Toast.makeText(LoginActivity.this, "Please fill in your username.", Toast.LENGTH_SHORT).show();
            }
            else if (passwordinput.getText().toString().isEmpty()){
                Toast.makeText(LoginActivity.this, "Please fill in your password.", Toast.LENGTH_SHORT).show();
            }
            else if(userinput.getText().toString().isEmpty() && passwordinput.getText().toString().isEmpty()){
                Toast.makeText(LoginActivity.this, "Please fill in your particulars.", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(LoginActivity.this, "Please fill in the correct particulars.", Toast.LENGTH_SHORT).show();
            }*/
            String loginuser, loginpass;
            loginuser = String.valueOf(userinput.getText());
            loginpass = String.valueOf(passwordinput.getText());
            if (TextUtils.isEmpty(loginuser)){
                Toast.makeText(LoginActivity.this, "Please enter your username.", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(loginpass)){
                Toast.makeText(LoginActivity.this, "Please enter your password.", Toast.LENGTH_SHORT).show();
                return;
            }
            if (loginuser == loginpass) {
                Toast.makeText(LoginActivity.this, "Your password cannot be identical to your username.Try again!!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (loginuser.length()<5 || loginpass.length()<5){
                Toast.makeText(LoginActivity.this, "Your details must be more than 5 characters long.", Toast.LENGTH_SHORT).show();
                return;
            }
            if (loginuser == loginpass) {
                Toast.makeText(LoginActivity.this, "Your password cannot be identical to your username.Try again!!", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.signInWithEmailAndPassword(loginuser, loginpass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "Login Successful!",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, HomePage.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(LoginActivity.this, "Login Failed!",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

        });


        registerbutton.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void initView(){
        userinput = findViewById(R.id.enteruser);
        passwordinput = findViewById(R.id.enterpassword);
        loginbutton = findViewById(R.id.login);
        registerbutton = findViewById(R.id.textregister);
        mAuth = FirebaseAuth.getInstance();
    }
}
