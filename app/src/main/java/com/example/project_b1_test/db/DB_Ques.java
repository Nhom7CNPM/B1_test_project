package com.example.project_b1_test.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DB_Ques extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Question.db";
    private SQLiteDatabase db;
    public DB_Ques(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.db = sqLiteDatabase;

        //biến bảng mã đề
        final String EXAM_TABLE = "CREATE TABLE " +
                Ques_Table.ExamID.TABLE_NAME + "( " +
                Ques_Table.ExamID._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Ques_Table.ExamID.COLUMN_NAME + " TEXT " + ")";

        //biến bảng câu hỏi
        final String QUESTION_TABLE = "CREATE TABLE " +
                Ques_Table.Question.TABLE_NAME + " ( " +
                Ques_Table.Question._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Ques_Table.Question.COLUMN_QUESTION + " TEXT, " +
                Ques_Table.Question.COLUMN_OPTION1 + " TEXT, " +
                Ques_Table.Question.COLUMN_OPTION2 + " TEXT, " +
                Ques_Table.Question.COLUMN_OPTION3 + " TEXT, " +
                Ques_Table.Question.COLUMN_OPTION4 + " TEXT, " +
                Ques_Table.Question.COLUMN_ANSWER + " INTEGER, " +
                Ques_Table.Question.COLUMN_ID + " INTEGER, " +
                "FOREIGN KEY(" + Ques_Table.Question.COLUMN_ID + ") REFERENCES " +
                Ques_Table.Question.TABLE_NAME + "(" + Ques_Table.Question._ID + ")" + "ON DELETE CASCADE" + ")";
        //tạo bảng
        db.execSQL(EXAM_TABLE);
        db.execSQL(QUESTION_TABLE);

        //insert data
        CreateIDexam();
        CreateQuestion();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Ques_Table.ExamID.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Ques_Table.Question.TABLE_NAME);
        onCreate(db);
    }

    //insert mã đề thi
    private void insertIDexam(Exam id){
        ContentValues values = new ContentValues();
        values.put(Ques_Table.ExamID.COLUMN_NAME, id.getName());

        db.insert(Ques_Table.ExamID.TABLE_NAME, null, values);
    }

    private void CreateIDexam(){
        Exam id1 = new Exam("1");
        insertIDexam(id1);
        Exam id2 = new Exam("2");
        insertIDexam(id2);
    }

    //insert các câu hỏi
    private void insertQuestion(Question question){
        ContentValues values = new ContentValues();

        values.put(Ques_Table.Question.COLUMN_QUESTION, question.getQuestion());
        values.put(Ques_Table.Question.COLUMN_OPTION1, question.getOption1());
        values.put(Ques_Table.Question.COLUMN_OPTION2, question.getOption2());
        values.put(Ques_Table.Question.COLUMN_OPTION3, question.getOption3());
        values.put(Ques_Table.Question.COLUMN_OPTION4, question.getOption4());
        values.put(Ques_Table.Question.COLUMN_ANSWER, question.getAnswer());
        values.put(Ques_Table.Question.COLUMN_ID, question.getId_exam());

        db.insert(Ques_Table.Question.TABLE_NAME, null, values);
    }

    private void CreateQuestion(){
        //Câu hỏi của đề 1
        Question q1 = new Question("______ raiding for camels was a significant part of Bedouin life has been documented in Wilfed Thesiger’s Arabian Sands.",
                "A. That", "B. Which", "C. What", "D. Where", 1,1);
        insertQuestion(q1);

        Question q2 = new Question("The little boy pleaded ______ not to leave him alone in the dark.",
                "A. on his mother", "B. his mother", "C. with his mother", "D. at his mother", 3,1);
        insertQuestion(q2);

        Question q3 = new Question("______, the people who come to this club are in their twenties and thirties.",
                "A. By and large", "B. Altogether", "C. To a degree", "D. Virtually", 1,1);
        insertQuestion(q3);

        Question q4 = new Question("The TV station, in ______ to massive popular demand, decided not to discontinue the soap opera.",
                "A. reaction","B. response","C. answer","D. rely", 2,1);
        insertQuestion(q4);

        Question q5 = new Question("His emotional problems ______ from the attitudes he encountered as a child, I think.",
                "A. stem" ,"B. flourish","C. root", "D. sprout", 1,1);
        insertQuestion(q5);

        Question q6 = new Question("Pete was born and brought up in Cornwall and he knows the place like the ______.",
                "A. nose on his face" ,"B. back of his hand","C. hairs on his head" ,"D. teeth of his mouth", 2,1);
        insertQuestion(q6);

        Question q7 = new Question("British and Australian people share the same language, but in other respects they are as different as ______.",
                "A. cats and dogs"," B. salt and pepper", "C. chalk and cheese ", "D. here and there", 3,1);
        insertQuestion(q7);

        Question q8 = new Question("Rows and silences are ______ and parcel of any marriage.",
                "A. package","B. stamps","C. packet","D. part", 4,1);
        insertQuestion(q8);

        Question q9 = new Question("Don’t ______ to any conclusion before you know the full facts.",
                "A. rush","B. dive","C. leap","D. fly", 3,1);
        insertQuestion(q9);

        Question q10 = new Question("A few animals sometimes fool their enemies ______ to be dead.",
                "A. have been appearing","B. to be appearing","C. to appear","D. by appearing", 4,1);
        insertQuestion(q10);

        Question q11 = new Question("On no account ______ in the office be used for personal materials.",
                "A. the photocopy machines","B. the photocopy machines should","C. should the photocopy machines","D. does the photocopy machines", 3,1);
        insertQuestion(q11);

        Question q12 = new Question("The ______ of the bank where he worked was not in the center of the city.",
                "A. branch" ,"B. seat","C. house" ,"D. piece", 1,1);
        insertQuestion(q12);

        Question q13 = new Question(" ______ from Bill, all the students said they would go.",
                "A. Except","B. Only","C. Apart","D. Separate", 3,1);
        insertQuestion(q13);

        Question q14 = new Question(" ______ my opinion, French cheese is better than English cheese.",
                "A. For" ,"B. To","C. By" ,"D. In", 4,1);
        insertQuestion(q14);

        Question q15 = new Question("When I bought the shoes, they ______ me well but later they were too tight at home",
                "A. matched" ,"B. fitted","C. suited","D. went with", 2,1);
        insertQuestion(q15);

        Question q16 = new Question("They received a ten year sentence for ______ armed robbery .",
                "A. making","B. doing","C. committing","D. practicing", 3,1);
        insertQuestion(q16);

        Question q17 = new Question("This magazine is very good. If you like reading, you should ______ to it.",
                "A. buy", "B. subscribe", "C. contribute","D. enroll", 2,1);
        insertQuestion(q17);

        Question q18 = new Question("In life ______ can make a mistake. We’re all human.",
                "A. anyone" , "B. someone", "C. some people" , "D. not anybody", 1,1);
        insertQuestion(q18);

        Question q19 = new Question("He’ll be very upset if you ______ his offer of help.",
                "A. turn away", "B. turn from", "C. turn down", "D. turn against", 3,1);
        insertQuestion(q19);

        Question q20 = new Question("Sally was (mortified) by her date’s unprecedented behavior",
                "A. eradicated","B. humiliated","C. overjoyed" ,"D. challenged", 2,1);
        insertQuestion(q20);

        Question q21 = new Question("The fourth year sociology class was a (homogeneous) group of university students",
                "A. uniform","B. dreary","C. unrelated","D. distinguishable", 1,1);
        insertQuestion(q21);

        Question q22 = new Question("The detective’s (resourcefulness) helped him solve the mystery",
                " A. assistance","B. skill","C. family","D. money", 2,1);
        insertQuestion(q22);

        Question q23 = new Question("Stephen Foster was one of America's most popular and (productive) song writers, composing more than two hundred songs in his lifetime.",
                "A. prolific","B. gifted","C. industrious","D. renowned", 1,1);
        insertQuestion(q23);

        Question q24 = new Question("Few scientific breakthroughs are discovered merely by (coincidence)",
                "A. talent","B. laymen","C. chance","D. imagination", 3,1);
        insertQuestion(q24);

        Question q25 = new Question("According to Freud, dreams can be interpreted as the (fulfilment) of wishes",
                "A. performance","B. completion","C. attainment","D. conclusion", 2,1);
        insertQuestion(q25);


        //Câu hỏi của đề 2
        Question q26 = new Question("I need to get some cash. Do you think we might pass a bank ______?",
                "A. in the way","B. to the way","C. on the way","D. at the way", 3,2);
        insertQuestion(q26);

        Question q27 = new Question("Will you ______ the children while I’m out?",
                "A. pay attention to", "B. care about","C. look after", "D. look out", 3,2);
        insertQuestion(q27);

        Question q28 = new Question("I liked the coat when I bought it , but now I’ve ______ my mind.",
                "A. altered","B. decided","C. reversed","D. changed", 1,2);
        insertQuestion(q28);

        Question q29 = new Question("In the middle of all the panic, she ______ phoned the police.",
                "A. silently" ,"B. calmly","C. peacefully","D. middy", 1,2);
        insertQuestion(q29);

        Question q30 = new Question("The boy’s mother was ______ in by his lies.",
                "A. drawn","B. taken","C. pulled","D. caught", 2,2);
        insertQuestion(q30);

        Question q31 = new Question("I find her ______ she never stops talking.",
                "A. exhaustion","B. exhaust","C. exhausting","D. exhausted", 3,2);
        insertQuestion(q31);

        Question q32 = new Question("I often wonder what people abroad make ______ Britain.",
                "A. from" ,"B. of","C. for","D. by", 2,2);
        insertQuestion(q32);

        Question q33 = new Question("There are about twenty ______ people waiting in the outer office.",
                "A. but","B. and","C. for","D. or", 4,2);
        insertQuestion(q33);

        Question q34 = new Question("The Comanche are largely of mixed blood India and Spanish (descent).",
                "A. pedigree","B. origin","C. race","D. birth", 2,2);
        insertQuestion(q34);

        Question q35 = new Question("Many people consider automobiles to be (essential) to American life.",
                "A. critical","B. accessible","C. necessary","D. advantageous", 3,2);
        insertQuestion(q35);

        Question q36 = new Question("Some species of birds, when migrating divide (according to) their age and sex.",
                "A. in keeping with","B. conforming to","C. in line with","D. in relation to", 3,2);
        insertQuestion(q36);

        Question q37 = new Question("Writing is a skill that requires (consistent) practice.",
                "A. invariable","B. orderly","C. regular","D. customary", 3,2);
        insertQuestion(q37);

        Question q38 = new Question("The traffic in town was very ______ and I arrived home earlier than expected.",
                "A. light","B. weak","C. little","D. few", 1,2);
        insertQuestion(q38);

        Question q39 = new Question("In all parts of the U.S there is (adequate) rainfall except near the Rock Mountains.",
                "A. sufficient","B. acceptable","C. abundant","D. suitable", 1,2);
        insertQuestion(q39);

        Question q40 = new Question("City governments are (belatedly) taking steps to revitalize downtown areas.",
                "A. Endlessly","B. impatiently","C. finally","D. recently", 3,2);
        insertQuestion(q40);

        Question q41 = new Question("Aerobic bacteria transforms wastes in water into less (dangerous) substances.",
                "A. Stable","B. precarious","C. tender","D. harmless", 2,2);
        insertQuestion(q41);

        Question q42 = new Question("The evidence that carbon dioxide levels are rising is ______.",
                "A. inevitable","B. unavoidable","C. undeniable","D. indelible", 3,2);
        insertQuestion(q42);

        Question q43 = new Question("I don’t agree with you, but your idea certainly gives me food ______.",
                "A. For fun","B. for consider","C. for thought","D. for thinking", 3,2);
        insertQuestion(q43);

        Question q44 = new Question("He opened the letter without ______ to read the address on the envelope",
                "A. worrying","B. bothering","C. fearing","D. caring", 2,2);
        insertQuestion(q44);

        Question q45 = new Question("Do you have any objections ______ this new road scheme?",
                "A. at", "B. with", "C. to", "D. for", 3,2);
        insertQuestion(q45);

        Question q46 = new Question("The police set a ______ to catch the thieves.",
                "A. plan" , "B. device" , "C. snare", "D. trap", 4,2);
        insertQuestion(q46);

        Question q47 = new Question("Although he was ______, he agreed to play tennis with me.",
                "A. exhaustion", "B. exhausted", "C. exhausting", "D. exhaustive", 2,2);
        insertQuestion(q47);

        Question q48 = new Question("______ I didn’t know how to do the job. But now I am making progress",
                "A. First", "B. First of all", "C. At first", "D. At the first.", 3,2);
        insertQuestion(q48);

        Question q49 = new Question("Language could ______ more quickly if there were more language exchange programs.",
                "A. be learning", "B. have learned", "C. have learning", "D. be learned", 4,2);
        insertQuestion(q49);

        Question q50 = new Question("She won the award for ______ her whole life to looking after the poor.",
                "A. paying", "B. devoting", "C. causing", "D. attracting", 2,2);
        insertQuestion(q50);
    }

    //hàm trả về danh sách mã đề
    public List<Exam> getDataExam(){
        List<Exam> examList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Ques_Table.ExamID.TABLE_NAME, null);
        if (cursor.moveToFirst()){
            do {
                Exam id = new Exam();
                id.setId(cursor.getInt(cursor.getColumnIndexOrThrow(Ques_Table.ExamID._ID)));
                id.setName(cursor.getString(cursor.getColumnIndexOrThrow(Ques_Table.ExamID.COLUMN_NAME)));
                examList.add(id);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return examList;
    }

    //hàm trả về danh sách câu hỏi có id = id_exam đã chọn
    public ArrayList<Question> getQuestion(int id){
        ArrayList<Question> questionArrayList = new ArrayList<>();

        db = getReadableDatabase();

        String selection = Ques_Table.Question.COLUMN_ID + " = ? ";

        String[] selectionArgs = new String[]{String.valueOf(id)};

        Cursor cursor = db.query(Ques_Table.Question.TABLE_NAME, null,selection,selectionArgs,null,null,null);
        if (cursor.moveToFirst()){
            do {
                Question question = new Question();

                question.setId(cursor.getInt(cursor.getColumnIndexOrThrow(Ques_Table.Question._ID)));
                question.setQuestion(cursor.getString(cursor.getColumnIndexOrThrow(Ques_Table.Question.COLUMN_QUESTION)));
                question.setOption1(cursor.getString(cursor.getColumnIndexOrThrow(Ques_Table.Question.COLUMN_OPTION1)));
                question.setOption2(cursor.getString(cursor.getColumnIndexOrThrow(Ques_Table.Question.COLUMN_OPTION2)));
                question.setOption3(cursor.getString(cursor.getColumnIndexOrThrow(Ques_Table.Question.COLUMN_OPTION3)));
                question.setOption4(cursor.getString(cursor.getColumnIndexOrThrow(Ques_Table.Question.COLUMN_OPTION4)));
                question.setAnswer(cursor.getInt(cursor.getColumnIndexOrThrow(Ques_Table.Question.COLUMN_ANSWER)));
                question.setId_exam(cursor.getInt(cursor.getColumnIndexOrThrow(Ques_Table.Question.COLUMN_ID)));

                questionArrayList.add(question);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return questionArrayList;
    }
}
