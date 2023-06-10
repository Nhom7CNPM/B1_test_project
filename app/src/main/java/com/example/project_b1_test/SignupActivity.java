package com.example.project_b1_test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_b1_test.db.Database;

public class SignupActivity extends AppCompatActivity{

    TextView BackSignIn;
    private EditText SignUpEmail, SignUpPass, ConfirmPass;
    private Button SignUpButton;
    Database MyDB;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        SignUpEmail = findViewById(R.id.signupemail);
        SignUpPass = findViewById(R.id.signuppassword);
        ConfirmPass = findViewById(R.id.confirmpassword);

        SignUpButton = findViewById(R.id.signupbtn);
        BackSignIn = findViewById(R.id.backsignin);

        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = SignUpEmail.getText().toString();
                String pass = SignUpPass.getText().toString();
                String cpass = ConfirmPass.getText().toString();

                if(email.equals("") || pass.equals("") || cpass.equals(""))
                {
                    Toast.makeText(SignupActivity.this, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(pass.equals(cpass))
                    {
                        // Kiểm tra email đăng kí đã có trong DB chưa
                        Boolean emailcheck = MyDB.checkemail(email);
                        if(emailcheck == false)
                        {
                            //Nếu chưa thì nhập tài khoản vào DB
                            Boolean regresult = MyDB.insertData(email,pass);
                            if(regresult == true)
                            {
                                Toast.makeText(SignupActivity.this, "Đăng ký tài khoản thành công!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(SignupActivity.this, "Đăng kí tài khoản thất bại!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(SignupActivity.this, "Tài khoản này đã tồn tại!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(SignupActivity.this, "Mật khẩu không trùng khớp!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        BackSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
