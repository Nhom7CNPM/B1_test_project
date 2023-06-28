package com.example.project_b1_test;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project_b1_test.db.DB_Login;

public class ForgotpassActivity extends AppCompatActivity  {
    EditText emailBox;
    Button resetBtn;
    DB_Login DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass);

        emailBox= findViewById(R.id.emailBox);
        resetBtn= findViewById(R.id.resetBtn);
        DB=new DB_Login(this);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailBox.getText().toString();
                Boolean checkmail= DB.checkusername(email);
                if(checkmail==true)
                {
                    startActivity(new Intent(ForgotpassActivity.this, ResetActivity.class));
                    getIntent().putExtra("Email",email);
                    finish();
                }
                else {
                    Toast.makeText(ForgotpassActivity.this, "Email does not exists", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
