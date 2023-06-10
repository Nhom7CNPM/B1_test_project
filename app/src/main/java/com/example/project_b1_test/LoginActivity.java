package com.example.project_b1_test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_b1_test.db.Database;

public class LoginActivity extends AppCompatActivity {

    private Database DB;
    private EditText LoginEmail,LoginPassword;
    private Button LoginButton;
    private TextView ForgotPass, SignUpReady;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginEmail =findViewById(R.id.loginemail);
        LoginPassword = findViewById(R.id.loginpassword);

        LoginButton = findViewById(R.id.loginbtn);

        DB = new Database(this);

        ForgotPass = findViewById(R.id.forgotpass);
        SignUpReady = findViewById(R.id.signupready);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = LoginEmail.getText().toString();
                String pass = LoginPassword.getText().toString();
                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pass))
                    Toast.makeText(LoginActivity.this, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkaccount = DB.checkaccount(email,pass);
                    if(checkaccount == true){
                        Toast.makeText(LoginActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(LoginActivity.this,"Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
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
