package com.example.project_b1_test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    ImageButton btnThiThu,btnCauTruc,btnMeo;
    Button btnlogout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnThiThu = (ImageButton)  findViewById(R.id.btnThiThu);
        btnCauTruc=(ImageButton)findViewById(R.id.btnCauTruc);
        btnMeo=(ImageButton)findViewById(R.id.btnMeo);
        btnlogout=(Button) findViewById(R.id.btnlogout);

        btnThiThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(MainActivity.this,StartTestActivity.class));
                finish();
            }
        });


        btnCauTruc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CauTrucActivity.class));
                finish();
            }
        });
        btnMeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MeoActivity.class));
                finish();
            }
        });

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                finish();
            }
        });
    }
}