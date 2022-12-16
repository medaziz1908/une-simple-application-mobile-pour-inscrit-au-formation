package com.example.projet_mobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//import android.support.annotation.Nullable;

public class DbManager extends SQLiteOpenHelper {


    private static final String dbname="Formation_Data.db";

    public DbManager(Context context)

    {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String qry="create table tbl_formation (id integer primary key autoincrement, name text, email text, phone text, class text)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS tbl_formation");
        onCreate(db);
    }

    public  String addRecord(String p1, String p2, String p3, String p4)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("name",p1);
        cv.put("email",p2);
        cv.put("phone",p3);
        cv.put("class",p4);

        long res=db.insert("tbl_formation",null,cv);


        if(res==-1)
            return "Failed";
        else
            return "Successfully inserted";
    }
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + "tbl_formation", null);
        return data;
    }














}
