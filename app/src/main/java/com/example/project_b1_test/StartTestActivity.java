package com.example.project_b1_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.project_b1_test.db.DB_Ques;
import com.example.project_b1_test.db.Exam;

import java.util.List;

public class StartTestActivity extends AppCompatActivity {
    private Spinner spinnerExam;
    private Button startBtn;
    private ImageView backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test);
        AnhXa();
        //load mã đề
        loadIDExam();
        //bắt đầu thi
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lấy id, mã đề đã chọn
                Exam exam = (Exam) spinnerExam.getSelectedItem();
                int examID = exam.getId();

                Intent intent = new Intent(StartTestActivity.this, TestActivity.class);
                //gửi dữ liệu id, mã đề
                intent.putExtra("examID", examID);
                //để nhận lại dữ liệu kết quả
                startActivity(intent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartTestActivity.this, MainActivity.class);
            }
        });
    }

    private void AnhXa(){
        spinnerExam = findViewById(R.id.spinner_exam);
        startBtn = findViewById(R.id.startbtn);
        backBtn = findViewById(R.id.backbtn);
    }

    private void loadIDExam(){
        DB_Ques db = new DB_Ques(this);
        //lấy danh sách chứa mã đề
        List<Exam> exams = db.getDataExam();
        //tạo adapter
        ArrayAdapter<Exam> examArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,exams);
        //bố cục hiển thị mã đề
        examArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //gán mã đề lên spinner hiển thị
        spinnerExam.setAdapter(examArrayAdapter);
    }
}
