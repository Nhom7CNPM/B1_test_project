package com.example.project_b1_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project_b1_test.db.DB_Login;

public class ResetActivity extends AppCompatActivity {
    TextView reset_text;
    EditText password_reset,RePassword_reset;
    Button confirm_button;
    DB_Login DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        reset_text= findViewById(R.id.reset_text);
        password_reset= findViewById(R.id.password_reset);
        RePassword_reset= findViewById(R.id.RePassword_reset);
        confirm_button= findViewById(R.id.confirm_button);
        DB =new DB_Login(this);

        Intent intent = getIntent();
        reset_text.setText(intent.getStringExtra("Email"));

        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Text = reset_text.getText().toString();
                String pass = password_reset.getText().toString();
                String repass= RePassword_reset.getText().toString();
                if(pass.equals(repass)){

                    Boolean check_pass_update=DB.updatepassword(Text,pass) ;
                    if(check_pass_update==true){
                        startActivity(new Intent(ResetActivity.this, LoginActivity.class));
                        Toast.makeText(ResetActivity.this,"password update successfully ",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(ResetActivity.this,"password update fail ",Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(ResetActivity.this,"password not matched  ",Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}