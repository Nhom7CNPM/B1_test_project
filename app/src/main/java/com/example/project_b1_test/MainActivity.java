package com.example.project_b1_test;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

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
                startActivity( new Intent(MainActivity.this,HomeActivity.class));
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
            }
        });
        btnMeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MeoActivity.class));
            }
        });


    }
}