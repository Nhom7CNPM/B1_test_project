package com.example.project_b1_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project_b1_test.db.DB_Login;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity{
    private TextView BackSignIn;
    private EditText SignUpEmail, SignUpPass, ConfirmPass;
    private Button SignUpButton;
    private DB_Login DB;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        DB = new DB_Login(this);

        SignUpEmail = findViewById(R.id.signupemail);
        SignUpPass = findViewById(R.id.signuppassword);
        ConfirmPass = findViewById(R.id.confirmpassword);

        SignUpButton = findViewById(R.id.signupbtn);
        BackSignIn = findViewById(R.id.backsignin);

        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = SignUpEmail.getText().toString();
                String password = SignUpPass.getText().toString();
                String cpassword = ConfirmPass.getText().toString();

                if(email.equals("")||password.equals("")||cpassword.equals(""))
                    Toast.makeText(SignUpActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else
                {
                    if(password.equals(cpassword))
                    {
                        Boolean checkuser = DB.checkusername(email);
                        if(!checkuser)
                        {
                            Boolean insert = DB.insertData(email, password);
                            if(insert)
                            {
                                Toast.makeText(SignUpActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(SignUpActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(SignUpActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(SignUpActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        BackSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });
    }
}
