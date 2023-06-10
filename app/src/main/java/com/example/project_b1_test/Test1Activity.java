package com.example.project_b1_test;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.project_b1_test.db.QandA1;

    public class Test1Activity extends AppCompatActivity implements View.OnClickListener {
        TextView totalQuestiontextview;
        TextView questiontextview;
        Button ansA,ansB,ansC,ansD;
        Button submit;
        int score = 0;
        int totalquestion = QandA1.Question.length;
    int curruentQuestionIndex = 0;
    String selectedAnswer = "";
    private CountDownTimer countDownTimer;
    TextView textView;
    ArrayList<String> selectedAnswersList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        totalQuestiontextview = (TextView) findViewById(R.id.Total_question);
        questiontextview = (TextView) findViewById(R.id.questions);
        ansA = (Button) findViewById(R.id.ans_A);
        ansB = (Button) findViewById(R.id.ans_B);
        ansC = (Button) findViewById(R.id.ans_C);
        ansD = (Button) findViewById(R.id.ans_D);

        submit = (Button) findViewById(R.id.submit);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submit.setOnClickListener(this);

        totalQuestiontextview.setText("Câu hỏi: " + totalquestion);
        loadNewQuestion();

        textView=(TextView) findViewById(R.id.time);
        totaltime();
        countDownTimer.start();
        selectedAnswersList = new ArrayList<>();
    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit){
            if(selectedAnswer.equals(Answerthequestion.correctAnswer[curruentQuestionIndex])) {
                score += 4;}
            curruentQuestionIndex++;
            loadNewQuestion();



        }
        else{
            selectedAnswer=clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
            selectedAnswersList.add(selectedAnswer);
        }
    }

    void loadNewQuestion(){
        if(curruentQuestionIndex==totalquestion){
            finishQuiz();
            return;
        }
        questiontextview.setText("Câu " + (curruentQuestionIndex + 1) + ": " + Answerthequestion.question[curruentQuestionIndex]);
        ansA.setText(Answerthequestion.choise[curruentQuestionIndex][0]);
        ansB.setText(Answerthequestion.choise[curruentQuestionIndex][1]);
        ansC.setText(Answerthequestion.choise[curruentQuestionIndex][2]);
        ansD.setText(Answerthequestion.choise[curruentQuestionIndex][3]);
    }
    void finishQuiz() {
        String passstatus = "";
        if (score > 60) {
            passstatus = "Bạn đã thi đỗ";
        } else {
            passstatus = "Bạn đã trượt";
        }
        new AlertDialog.Builder(this)
                .setTitle(passstatus)
                .setMessage("Điểm của bạn là " + score + " trên 100 điểm")
                .setPositiveButton("Làm lại", (dialogInterface, i) -> restartQuiz())
                .setNegativeButton("Xem lại", (dialogInterface, i) -> showAnswers())
                .setCancelable(false)
                .show();
    }

    void restartQuiz(){
        score=0;
        curruentQuestionIndex=0;
        loadNewQuestion();
    }

    void showAnswers(){
        // Tạo một mảng lưu trữ đáp án đã chọn và đáp án đúng
        ArrayList<String> answersList = new ArrayList<>();
        ArrayList<String> correctAnswersList = new ArrayList<>();

        for (int i = 0; i < Answerthequestion.question.length; i++) {
            String selectedAnswer = "";
            if (i < selectedAnswersList.size()) {
                selectedAnswer = selectedAnswersList.get(i);
            }
            String correctAnswer = Answerthequestion.correctAnswer[i];

            answersList.add("Câu hỏi " + (i + 1) + ": \n" + Answerthequestion.question[i] +
                    "\nĐáp án bạn chọn: " + selectedAnswer +
                    "\nĐáp án đúng: " + correctAnswer + "\n");

            correctAnswersList.add(correctAnswer);
        }

        // Chuyển sang màn hình hiển thị câu hỏi và câu trả lời đã chọn
        // Chuyển sang màn hình hiển thị câu hỏi và câu trả lời đã chọn
        Intent intent = new Intent(Test1Activity.this, ReviewAnswersActivity.class);
        intent.putStringArrayListExtra("selectedAnswersList", selectedAnswersList);
        intent.putStringArrayListExtra("correctAnswersList", correctAnswersList);
        intent.putStringArrayListExtra("answersList", answersList);
        Test1Activity.this.startActivity(intent); // Thêm Test1Activity.this trước startActivity

    }




    private void totaltime() {
        long totalTimeInMillis = 25 * 60 * 1000;

        // Khởi tạo đối tượng CountDownTimer
        countDownTimer = new CountDownTimer(totalTimeInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Cập nhật giá trị trong TextView sau mỗi 1 giây
                int minutes = (int) (millisUntilFinished / 1000) / 60;
                int seconds = (int) (millisUntilFinished / 1000) % 60;
                String timeLeftFormatted = String.format("%02d:%02d", minutes, seconds);
                textView.setText(timeLeftFormatted);
            }

            @Override
            public void onFinish() {
                // Xử lý khi đếm ngược hoàn thành
                textView.setText("00:00");
                // Hiển thị AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(Test1Activity.this);
                builder.setMessage("Bạn đã hết thời gian");
                builder.setPositiveButton("Làm lại", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Code xử lý khi người dùng click nút "Làm lại"
                        // Gọi phương thức để bắt đầu lại đếm ngược
                        totaltime();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        }.start();
    }
}



