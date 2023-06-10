package com.example.project_b1_test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_b1_test.db.Database;

public class LoginActivity extends AppCompatActivity {

    private Database Database;
    private EditText LoginEmail,LoginPassword;
    private Button LoginButton;
    private TextView ForgotPass, SignUpReady;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginEmail =findViewById(R.id.signinemail);
        LoginPassword = findViewById(R.id.signinpassword);
        LoginButton = findViewById(R.id.signinbtn);
        ForgotPass = findViewById(R.id.forgotpass);
        SignUpReady = findViewById(R.id.signupready);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = LoginEmail.getText().toString();
                String pass = LoginPassword.getText().toString();
                if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if(!pass.isEmpty()){

                    }
                }
            }
        });

        SignUpReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}
