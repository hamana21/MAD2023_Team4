package sg.np.madasg1iman;

import static android.provider.MediaStore.MediaColumns.TITLE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.madasg1iman.R;

public class LoginActivity extends AppCompatActivity {

    private EditText userinput, passwordinput;
    private Button loginbutton, registerbutton;

    SharedPreferences preferences;
    private static final String SHARED_PREF_NAME = "MyPref";
    private static final String KEY_NAME = "Username";
    private static final String KEY_PASS = "Password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.v(TITLE, "CREATE!");
        initView();
        preferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        setVariable();

    }
    private void setVariable(){
        loginbutton.setOnClickListener(v -> {
            String loginuser = userinput.getText().toString();
            String loginpass = passwordinput.getText().toString();
            String registereduser = preferences.getString(KEY_NAME,"");
            String registeredpass = preferences.getString(KEY_PASS,"");
            if (loginuser.equals(registereduser)&& loginpass.equals(registeredpass)){
                Toast.makeText(LoginActivity.this, "Log In Successful!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, HomePage.class);
                startActivity(intent);
            }
            else if(userinput.getText().toString().isEmpty() && passwordinput.getText().toString().isEmpty()){
                Toast.makeText(LoginActivity.this, "Please fill in your particulars.", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(LoginActivity.this, "Please fill in the correct particulars.", Toast.LENGTH_SHORT).show();
            }
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
        registerbutton = findViewById(R.id.register);
    }
}
