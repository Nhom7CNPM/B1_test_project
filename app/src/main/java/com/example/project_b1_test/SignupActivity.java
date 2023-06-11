package com.example.project_b1_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class SignupActivity extends AppCompatActivity{

    DatabaseReference dbr = FirebaseDatabase.getInstance().getReferenceFromUrl("https://project-b1-test-default-rtdb.firebaseio.com/");
    private FirebaseAuth auth;
    private TextView BackSignIn;
    private EditText SignUpEmail, SignUpPass, ConfirmPass;
    private Button SignUpButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();

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

                if(email.isEmpty() || pass.isEmpty() || cpass.isEmpty())
                {
                    Toast.makeText(SignupActivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else if(pass.equals(cpass))
                {
                    dbr.child("email").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            // Kiểm tra tài khoản đã tồn tại
                            if(snapshot.hasChild(email))
                            {
                                Toast.makeText(SignupActivity.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                dbr.child("email").child(email).child("pass").setValue(pass);

                                Toast.makeText(SignupActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                                finish();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                else
                {
                    Toast.makeText(SignupActivity.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                }
            }
        });

        BackSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });
    }
}
