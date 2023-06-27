package sg.np.madasg1iman;

import static android.provider.MediaStore.MediaColumns.TITLE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.v(TITLE, "CREATE!");
        initView();
        setVariable();
    }
    private void setVariable(){
        loginbutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                if(userinput.getText().toString().isEmpty() && passwordinput.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please fill in your particulars.", Toast.LENGTH_SHORT).show();
                }
                else if(userinput.getText().toString().equals("madassg1") && passwordinput.getText().toString().equals("madassg1"))
                {
                    startActivity(new Intent(LoginActivity.this,HomePage.class));
                }
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
