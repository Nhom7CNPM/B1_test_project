package com.example.project_b1_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
public class CauTrucActivity extends AppCompatActivity {
    ListView LvCauTruc;
    ArrayList<Cautruc> arraycautruc;
    CautrucAdapter CautrucAdapter;
    private ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_meo);
        Anhxa3();
        CautrucAdapter =new CautrucAdapter(this,R.layout.activity_meo,arraycautruc);
        LvCauTruc.setAdapter(CautrucAdapter);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CauTrucActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Anhxa3(){
        LvCauTruc =(ListView) findViewById(R.id.listviewmeo);
        arraycautruc=new ArrayList<>();
        backBtn=findViewById(R.id.backbtn);
        arraycautruc.add(new Cautruc("1.Dạng bài ngữ âm/ trọng âm:\n",
                "Trong cấu trúc đề thi tiếng Anh, dạng bài ngữ âm thường xuất hiện đầu tiên. Đối với dạng bài này, các bạn học sinh cần chọn đáp án có phần gạch chân được phát âm khác so với các đáp án còn lại.\n" +
                        "\n" +
                        "Dạng bài Ngữ âm sẽ gồm 2 câu về phát âm và 2 câu về trọng âm. Trong đó:\n" +
                        "\n" +
                        "Dạng phát âm sẽ gồm 1 câu về cách phát âm phụ âm và 1 câu về cách phát âm nguyên âm.\n" +
                        "Dạng trọng âm sẽ gồm 1 câu về trọng âm của từ 2 âm tiết, và 1 câu về trọng âm của từ 3 âm tiết."
                      ));
        arraycautruc.add(new Cautruc("2. Dạng bài hoàn thành câu\n",
                "Dạng bài này gồm 15 câu hỏi xoay quanh các chủ điểm từ vựng và ngữ pháp thông dụng như đã đề cập trong phần trước như: thì của động từ, loại từ, idioms hay phrasal verbs, … \n" +
                        "\n" +
                        "Để chọn đáp án đúng cho các câu hỏi dạng này, các bạn cần ôn tập theo các chủ điểm ngữ pháp quan trọng và luyện đề."));
        arraycautruc.add(new Cautruc("3.Dạng bài tìm từ đồng nghĩa – trái nghĩa\n",
                "Đây là một trong những dạng bài khá “khó nhằn\" trong cấu trúc đề thi môn tiếng Anh. Bạn cần chọn từ có nghĩa tương đương, hoặc trái ngược với từ đề bài cho. Tương tự như dạng bài hoàn thành câu, đề bài cũng sẽ cho bạn 4 đáp án để lựa chọn.\n"
                ));
        arraycautruc.add(new Cautruc( "4.Dạng bài chức năng giao tiếp\n",
                "Chức năng giao tiếp là dạng bài yêu cầu bạn phải hoàn thành đoạn hội thoại bằng cách chọn đáp án đúng. Câu hỏi đưa ra thường là những câu mời, đề nghị, câu mệnh lệnh, lời cảm ơn và xin lỗi trong tiếng Anh. Nhiệm vụ của bạn là chọn câu đối đáp phù hợp. "
                ));
        arraycautruc.add(new Cautruc("5.Dạng bài đọc hiểu\n",
                "Dạng bài đọc hiểu có yêu cầu tương tự như dạng bài hoàn thành đoạn văn. Với dạng bài này, đề thi sẽ đưa ra 2 bài đọc với tổng số 12 câu hỏi.\n" +
                        "\n" +
                        "Thông thường, đoạn văn dài hơn sẽ khó hơn và độ khó nằm trong mức B1 hoặc B2. Tuy nhiên, bạn không cần hiểu 100% nội dung của bài đọc vẫn có thể chọn được đáp án đúng nếu có phương pháp làm bài phù hợp."
                ));
        arraycautruc.add(new Cautruc("6. Dạng bài tìm lỗi sai\n",
                "Dạng bài tiếp theo trong cấu trúc đề thi tiếng Anh là dạng bài tìm lỗi sai. Trong những năm gần đây, đề thi sẽ yêu cầu sĩ tử tìm cả lỗi sai từ vựng và ngữ pháp.\n" +
                        "\n" +
                        "Tuy nhiên, tỷ trọng giữa câu tìm lỗi sai ngữ pháp và từ vựng không cân bằng, thường là 2 câu ngữ pháp và 1 câu từ vựng. Xu hướng ra đề này cũng dễ hiểu vì ngữ pháp thường khó hơn từ vựng."
        ));
    }

}


