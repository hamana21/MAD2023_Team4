package sg.np.madasg1iman;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.madasg1iman.R;

public class RegisterActivity extends AppCompatActivity{
    EditText userreg, passwordreg;
    Button register,cancel;

    SharedPreferences preferences;
    private static final String SHARED_PREF_NAME = "MyPref";
    private static final String KEY_NAME = "Username";
    private static final String KEY_PASS = "Password";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userreg = findViewById(R.id.enteruserreg);
        passwordreg = findViewById(R.id.enterpasswordreg);
        register = findViewById(R.id.registerbutton);
        cancel = findViewById(R.id.cancel);

        preferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uservalue = userreg.getText().toString();
                String passvalue = passwordreg.getText().toString();

                if (uservalue.length()>1){
                    editor.putString(KEY_NAME,uservalue);
                    editor.putString(KEY_PASS,passvalue);
                    editor.apply();
                    Toast.makeText(RegisterActivity.this, "User Registered!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Please fill up the form.", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        cancel.setOnClickListener((v) -> {
        cancelregister();
        });


    }
    public void cancelregister(){
        Toast.makeText(RegisterActivity.this, "Registration Form Cancelled", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
