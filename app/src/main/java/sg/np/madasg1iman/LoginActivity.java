package sg.np.madasg1iman;

import static android.provider.MediaStore.MediaColumns.TITLE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.madasg1iman.R;

public class LoginActivity extends AppCompatActivity {

    private EditText userinput, passwordinput;
    private Button loginbutton, registerbutton;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.v(TITLE, "CREATE!");
        initView();
        preferences = getSharedPreferences("Userinfo",0);
        setVariable();

    }
    private void setVariable(){
        loginbutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                String loginuser = userinput.getText().toString();
                String loginpass = passwordinput.getText().toString();
                String registereduser = preferences.getString("username","");
                String registeredpass = preferences.getString("password","");
                if (loginuser.equals(registereduser)&& loginpass.equals(registeredpass)){
                    Intent intent = new Intent(LoginActivity.this, HomePage.class);
                    startActivity(intent);
                }
                else if(userinput.getText().toString().isEmpty() && passwordinput.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please fill in your particulars.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Please fill in the correct particulars.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView(){
        userinput = findViewById(R.id.enteruser);
        passwordinput = findViewById(R.id.enterpassword);
        loginbutton = findViewById(R.id.login);
        registerbutton = findViewById(R.id.register);
    }
}
