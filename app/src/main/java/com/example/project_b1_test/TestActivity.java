package com.example.project_b1_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project_b1_test.db.DB_Ques;
import com.example.project_b1_test.db.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class TestActivity extends AppCompatActivity {

    private TextView Total_question,time,questions;
    private Button submit;
    private RadioButton rb1,rb2,rb3,rb4;
    private RadioGroup rbg;
    private CountDownTimer countDownTimer;
    private ArrayList<Question> questionList;
    private long timeLeftInMillis;
    private int questionCounter;
    private int questionSize;
    private Question currentQuestion;

    private int Score;
    private boolean answered;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        anhxa();
        //nhận dữ liệu mã đề
        Intent intent = getIntent();
        int examID = intent.getIntExtra("examID", 0);

        DB_Ques database = new DB_Ques(this);

        questionList = database.getQuestion(examID);
        //tổng số câu
        questionSize = questionList.size();
        //đảo các câu hỏi
        Collections.shuffle(questionList);
        //câu tiếp theo
        showNextQuestion();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered){
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()){
                        checkAnswer();
                    }else {
                        Toast.makeText(TestActivity.this,"Hãy chọn đáp án", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        //Nếu còn câu hỏi chưa hiện
        if (questionCounter < questionSize){
            //lấy dữ liệu ở vị trí counter
            currentQuestion = questionList.get(questionCounter);
            //hiển thị câu hỏi
            questions.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());
            //tăng sau mỗi câu hỏi
            questionCounter++;
            //câu hỏi hiện tại
            Total_question.setText("Câu hỏi: " + questionCounter +"/"+questionSize);

            answered = false;
            timeLeftInMillis = 60000;
            startCountDown();
            // Đặt lại trạng thái ban đầu cho các nút RadioButton
            rb1.setChecked(false);
            rb2.setChecked(false);
            rb3.setChecked(false);
            rb4.setChecked(false);

            rb1.setTextColor(Color.WHITE);
            rb2.setTextColor(Color.WHITE);
            rb3.setTextColor(Color.WHITE);
            rb4.setTextColor(Color.WHITE);
        }
        else {
            finishQuestion();
        }
    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;

                updateCountDownText();
            }

            @Override
            public void onFinish() {
                //hết giờ
                timeLeftInMillis = 0;
                updateCountDownText();
                //kiểm tra kq
                checkAnswer();
            }
        }.start();
    }

    private void checkAnswer() {
        //true đã trả lời
        answered = true;
        RadioButton rbSelected = findViewById(rbg.getCheckedRadioButtonId());
        int answer = rbg.indexOfChild(rbSelected) + 1;
        if (answer == currentQuestion.getAnswer()){
            Score = Score + 4;
        }
        showAnswer();
    }

    private void showAnswer() {
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);
        //đổi màu xanh nếu đúng
        switch (currentQuestion.getAnswer()) {
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                break;
        }
        if (questionCounter < questionSize){
            submit.setText("Câu tiếp");
        }
        else {
            submit.setText("Hoàn thành");
        }
        countDownTimer.cancel();
    }

    private void updateCountDownText() {
        int minutes = (int) ((timeLeftInMillis/1000)/60);
        int seconds = (int) ((timeLeftInMillis/1000)%60);

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d",minutes,seconds);
        time.setText(timeFormatted);
        if (timeLeftInMillis < 10000){
            time.setTextColor(Color.RED);
        }
        else{
            time.setTextColor(Color.BLACK);
        }
    }

    private void finishQuestion() {
        //chứa dữ liệu điểm gửi lại main
        Intent resultIntent = new Intent();
        resultIntent.putExtra("Score: ", Score);
        setResult(RESULT_OK,resultIntent);
        finish();
    }

    private void anhxa(){
        Total_question = findViewById(R.id.Total_question);
        time = findViewById(R.id.time);
        questions = findViewById(R.id.questions);
        rbg = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_btn1);
        rb2 = findViewById(R.id.radio_btn2);
        rb3 = findViewById(R.id.radio_btn3);
        rb4 = findViewById(R.id.radio_btn4);
        submit = findViewById(R.id.submit);
    }
}