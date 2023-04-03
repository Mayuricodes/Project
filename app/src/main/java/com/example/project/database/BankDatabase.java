package com.example.project.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.project.Model.BankModel;

public class BankDatabase extends SQLiteOpenHelper {

    public static final String DB_NAME = "BankDatabase";
    public static final int version = 6;
    public static final String TABLE_NAME = "Bank";


//keys of our tables
public static final String KEY_ID = "id";

    public static final String USER_NAME = "NAME";
    public static final String USER_MOBILE = "MOBILE";
    public static final String USER_EMAIL = "EMAIL";
    public static final String USER_PIN = "PIN";
    public static final String USER_BALANCE = "BALANCE";


    public static final String USER_ACTION_TIME = "TIME";
    public static final String USER_ACTION_TYPE = "TYPE";
    public static final String USER_ACTION_AMT = "AMOUNT";

    SQLiteDatabase db;

    public BankDatabase(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String res = " CREATE TABLE "
                + TABLE_NAME + "(" +
                " " + USER_NAME + " TEXT ,"
                + USER_MOBILE + " INTEGER PRIMARY KEY , "
                + USER_EMAIL + " TEXT , "
                + USER_PIN + " INTEGER , "
                + USER_BALANCE + " INTEGER " + ")";


        sqLiteDatabase.execSQL(res);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public void insertData(String name, String email, String mobile_no, String pin) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_NAME, name);
        values.put(USER_EMAIL, email);
        values.put(USER_MOBILE, mobile_no);
        values.put(USER_BALANCE, "10000");
        values.put(USER_PIN, pin);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public void UpdateData(BankModel bankModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(USER_MOBILE,"1234567890");//static
        cv.put(USER_BALANCE,"10,000");
        cv.put(USER_PIN,"1234");
        //jiska no update krna hai uski hi id li hai  pure database ke undar jo column hai key id wala wo compare kiya jayega ki konsa id match kr raha hai jo yaha contact model or id se provide kr raha hou jesi hi match hoga updation hoga

        //db.update(TABLE_NAME,cv,USER_MOBILE+"="+bankModel.mobile_no;

    }





    public boolean login(String mobile, String pin){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Bank where MOBILE =? and PIN=?",new String[]{mobile, pin});
        return cursor.getCount()> 0;
    }
}








//Cursor to point to a single row of the result fetched by the query.
