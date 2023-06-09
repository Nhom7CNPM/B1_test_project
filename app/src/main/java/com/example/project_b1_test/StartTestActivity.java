package com.example.project_b1_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StartTestActivity extends AppCompatActivity {
    private TextView cateName,testNo,totalQ,bestScore,time;
    private Button starttestbtn;
    private ImageView backB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test);
        init();
    }
    private void init(){
        cateName = findViewById(R.id.textView);
        testNo=findViewById(R.id.start_view);
        totalQ=findViewById(R.id.totalQ);
        time=findViewById(R.id.time);
        starttestbtn=findViewById(R.id.startbtn);
        backB=findViewById(R.id.backB);
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartTestActivity.this.finish();
            }
        });

        starttestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(StartTestActivity.this,Test1Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
