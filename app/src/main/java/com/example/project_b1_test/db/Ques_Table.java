package com.example.project_b1_test.db;

import android.provider.BaseColumns;

public class Ques_Table {
    private Ques_Table(){}

    public static class ExamID implements BaseColumns {
        public static final String TABLE_NAME = "exams";
        public static final String COLUMN_NAME = "number";
    }

    public static class Question implements BaseColumns{
        //tên bảng
        public static final String TABLE_NAME = "questions";
        //câu hỏi
        public static final String COLUMN_QUESTION = "question";
        //đáp án
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        //đáp án đúng
        public static final String COLUMN_ANSWER = "answer";
        //mã đề thi
        public static final String COLUMN_ID = "id_exam";
    }
}
