package com.example.project_b1_test.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public static final String DBNAME = "Account.db";

    public Database(Context context) {
        super(context, "Account.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table emails(email TEXT PRIMARY KEY, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists emails");
    }

    public Boolean insertData(String email, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("signupemail",email);
        contentValues.put("signuppass",password);
        long result = MyDB.insert("emails",null,contentValues);
        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Boolean checkemail(String email) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from emails where email = ?", new String[] {email});
        if (cursor.getCount() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean checkaccount(String email, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from emails where email = ? and password = ?", new String[] {email,password});
        if (cursor.getCount() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
