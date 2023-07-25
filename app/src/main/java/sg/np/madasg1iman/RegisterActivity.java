package sg.np.madasg1iman;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.madasg1iman.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity{
    EditText userreg, passwordreg;
    Button register,cancel;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userreg = findViewById(R.id.enteruserreg);
        passwordreg = findViewById(R.id.enterpasswordreg);
        register = findViewById(R.id.registerbutton);
        cancel = findViewById(R.id.cancel);
        mAuth = FirebaseAuth.getInstance();


        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String uservalue, passvalue;
                uservalue = String.valueOf(userreg.getText());
                passvalue = String.valueOf(passwordreg.getText());
                if (TextUtils.isEmpty(uservalue)){
                    Toast.makeText(RegisterActivity.this, "Please enter your username.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(passvalue)){
                    Toast.makeText(RegisterActivity.this, "Please enter your password.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (passvalue.length()<6){
                    Toast.makeText(RegisterActivity.this, "Your password must be more than 5 characters long.", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{mAuth.createUserWithEmailAndPassword(uservalue, passvalue)

                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Toast.makeText(RegisterActivity.this, "User Registered!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(RegisterActivity.this, "Registration failed!",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

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
