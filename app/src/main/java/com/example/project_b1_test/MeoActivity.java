package com.example.project_b1_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MeoActivity extends AppCompatActivity {
    ListView lvMeo;
    ArrayList<Meo> arraymeo;
    MeoAdapter MeoAdapter;
    private ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_meo);
        Anhxa2();
        MeoAdapter =new MeoAdapter(this,R.layout.activity_meo,arraymeo);
        lvMeo.setAdapter(MeoAdapter);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MeoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Anhxa2 (){
        lvMeo =(ListView) findViewById(R.id.listviewmeo);
        arraymeo=new ArrayList<>();
        backBtn = findViewById(R.id.backbtn);
        arraymeo.add(new Meo("1.Dạng bài ngữ âm/ trọng âm:\n",
                "- Trọng âm thường rơi vào các đuôi dễ nhận biết như: ion, er, al, ity, ly, ist,….\n" +
                "- Trọng âm rơi vào âm tiết thứ hai nếu là danh từ.\n" +
                "- Trọng âm rơi vào âm tiết thứ nhất nếu là động từ.\n"+
                "- Còn đối với phần trọng âm, đề thi thường ra những câu hỏi và trọng âm 2 âm tiết hoặc 3 âm tiết trở lên. Vậy nên mẹo khoanh trắc nghiệm tiếng Anh phần trọng âm ở đây chính là bạn phải nắm vững được kiến thức về trọng âm 2 âm tiết và trọng âm 3 âm tiết trở lên."));
        arraymeo.add(new Meo("2. Dạng bài hoàn thành câu\n" ,
                "Hay chúng ta thường gọi là dạng bài đục lỗ. Mẹo làm bài giúp bạn lựa chọn chính xác được đáp án trai qua 3 bước. Cụ thể:\n"+
                "- Bước 1:  Đọc câu hỏi, xác định loại từ cần điền vào chỗ trống.\n"+
                "- Bước 2: Loại bỏ các dạng từ không phù hợp trong đáp án.\n"+
                "- Bước 3: Chọn đáp án đúng."));
        arraymeo.add(new Meo("3. Dạng bài tìm từ đồng nghĩa – trái nghĩa.\n" ,
                "- Đây là một trong những dạng bài tập trắc nghiệm rất hay xuất hiện trong các bài thi tiếng anh. Việc nắm và thuộc lòng các từ vựng về đồng và trái nghĩa thôi là chưa đủ. Chắc chắn bạn phải cần đến một số mẹo khoanh trắc nghiệm tiếng Anh phần từ đồng nghĩa/ trái nghĩa nữa. Cụ thể:\n"+
                "Mẹo trắc nghiệm tiếng Anh về từ đồng nghĩa:\n" +
                "Trường hợp 1: khi biết sẵn từ được gạch chân, ta sẽ thay trực tiếp đáp án A, B, C, D và xem đáp án nào phù hợp về nghĩa và ngữ cảnh nhất.\n" +
                "Trường hợp 2: khi ta không biết nghĩa của từ được gạch chân, thì cách hữu hiệu nhất là dựa vào ngữ cảnh để đoán nghĩa của từ\n"+
                "Mẹo trắc nghiệm tiếng Anh về từ trái nghĩa:\n" +
                "Thứ 1: thay thế từ được gạch chân với các đáp án A, B, C, D, xem đáp án nào ngược nghĩa với từ gạch chân thì ta chọn. Cách này là nhanh nhất trong trường hợp mình biết nghĩa của từ được gạch chân và từ trong các đáp án A, B, C, D rồi. Sau khi “ưng” đáp án nào thì mình ghép vào câu hỏi gốc để xem có phù hợp với ngữ cảnh của câu không nhé!\n" +
                "Thứ 2: đoán từ dựa vào ngữ cảnh khi ta chưa biết nghĩa của từ được gạch chân."));
        arraymeo.add(new Meo("4. Dạng bài chức năng giao tiếp\n" ,
                "Để có thể làm tốt những câu hỏi thuộc dạng câu hỏi giao tiếp. Bắt buộc thí sinh cần có kiến thức về dạng câu hỏi này. Một số mẫu câu giao tiếp thường xuất hiện trong đề thi như: \n" +
                "\n" +
                "Mẫu câu mời: Let’s / Shall we? / Would you like to? \n" +
                "Mẫu câu bày tỏ quan điểm: I think so / I’m not sure about that / What do you think? / Do you like it? \n" +
                "Mẫu câu cảm ơn/ xin lỗi "
                ));
        arraymeo.add(new Meo("5.Dạng bài đọc hiểu\n" ,
                "Đây là dạng bài nằm trong số dạng bài khó và chiếm tỉ trọng lớn trong bài. Cụ thể là 17 câu trong đề thi tiếng Anh. Do đó, đối những sĩ tử chuyên anh và muốn chinh phục thang điểm 9+. Thì chắc chắn, bạn không được sai dạng bài này. Một số dạng câu hỏi thường xuất hiện như sau:\n" +
                "\n" +
                "Dạng câu hỏi tìm thông tin chi tiết \n" +
                "Dạng câu hỏi suy luận, tìm thông tin tổng quát\n" +
                "Dạng câu hỏi về từ đồng nghĩa\n" +
                "Dạng câu hỏi về đại từ thay thế\n" +
                "Các công thức trắc nghiệm tiếng Anh giúp bạn chinh phục trọn vẹn 3,4 điểm trong phần này. Đó là: đọc qua thông tin cả đoạn văn một cách tổng quát. Sau đó chú ý đến nội dung câu hỏi và tìm thông tin liên quan ở đoạn văn. Cuối cùng lựa chọn đáp án đúng nhất với câu hỏi được đề bài đưa ra."));
        arraymeo.add(new Meo("6. Dạng bài tìm lỗi sai\n",
                "Dạng bài này đòi hỏi bạn phải nắm vững được tất tần tật kiến thức nền tiếng Anh. Đề thi thường kiểm tra lỗi sai về mặt từ vựng và mặt ngữ pháp.\n" +
                "\n" +
                "Vậy nên mẹo khoanh trắc nghiệm ở đây chính là nắm chắc được từ vựng. Đồng thời phân biệt được các dạng – loại từ, nắm chắc nghĩa của từ và cách dùng từ.\n" +
                "\n" +
                "Còn đối với phần ngữ pháp, thí sinh phải nắm chắc được các phạm trù ngữ pháp: câu bị động, thì của động từ, cấu trúc song song, trật tự từ, câu chẻ."
                ));

    }
}
