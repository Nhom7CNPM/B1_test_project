package com.example.project_b1_test;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ReviewAnswersActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_answers);

        listView = findViewById(R.id.listView);

        // Lấy danh sách câu trả lời đã chọn từ intent
        Intent intent = getIntent();
        ArrayList<String> selectedAnswersList = intent.getStringArrayListExtra("selectedAnswersList");
        ArrayList<String> correctAnswersList = intent.getStringArrayListExtra("correctAnswersList");
        ArrayList<String> answersList = intent.getStringArrayListExtra("answersList"); // Lấy dữ liệu câu hỏi, câu trả lời và đáp án đúng

        // Tạo một mảng để hiển thị trên ListView
        ArrayList<String> dataList = new ArrayList<>();
        for (int i = 0; i < selectedAnswersList.size(); i++) {
            // Hiển thị số câu hỏi, câu trả lời đã chọn và đáp án đúng
            dataList.add(answersList.get(i)+ " ");
        }

        // Hiển thị dữ liệu trên ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);
    }
}
