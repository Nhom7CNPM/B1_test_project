package com.example.project_b1_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button test1butn,test2butn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        test1butn =(Button) findViewById(R.id.test1btn);
        test2butn =(Button) findViewById(R.id.test2btn);

        test1butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,StartTestActivity.class));
            }
        });
//        test2butn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(HomeActivity.this,StartTest2Activity.class));
//            }
//        });
    }
}