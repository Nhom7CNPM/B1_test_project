package com.example.project_b1_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    ImageButton btnThiThu,btnCauTruc,btnMeo;
    Button btnmyaccount;
    Button homebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homebtn=(Button) findViewById(R.id.homebtn);
        btnmyaccount=(Button) findViewById(R.id.myaccountbtn);
        btnThiThu = (ImageButton)  findViewById(R.id.btnThiThu);
        btnCauTruc=(ImageButton)findViewById(R.id.btnCauTruc);
        btnMeo=(ImageButton)findViewById(R.id.btnMeo);

        btnThiThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(MainActivity.this,StartTestActivity.class));
                finish();
            }
        });

//        btnmyaccount.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this,LogoutActivity.class));
//            }
//        });
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
    }
}