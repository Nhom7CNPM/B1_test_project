package com.example.project_b1_test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    DatabaseReference dbr = FirebaseDatabase.getInstance().getReferenceFromUrl("https://project-b1-test-default-rtdb.firebaseio.com/");
    private FirebaseAuth auth;
    private EditText LoginEmail,LoginPassword;
    private Button LoginButton;
    private TextView SignUpReady;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth=FirebaseAuth.getInstance();

        LoginEmail =findViewById(R.id.loginemail);
        LoginPassword = findViewById(R.id.loginpassword);

        LoginButton = findViewById(R.id.loginbtn);
        SignUpReady = findViewById(R.id.signupready);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = LoginEmail.getText().toString();
                String pass = LoginPassword.getText().toString();
                if(!email.isEmpty() || !pass.isEmpty())
                {
                    dbr.child("email").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(email))
                            {
                                final String getPass = snapshot.child(email).child("pass").getValue(String.class);
                                if (getPass.equals(pass))
                                {
                                    Toast.makeText(LoginActivity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                    finish();
                                }
                                else
                                {
                                    Toast.makeText(LoginActivity.this,"Đăng nhập không thành công",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error)
                        {

                        }
                    });
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Điền đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                }
            }
        });
        SignUpReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
                finish();
            }
        });
    }
}
