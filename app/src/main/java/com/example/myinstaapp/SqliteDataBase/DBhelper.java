package com.example.myinstaapp.SqliteDataBase;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBhelper extends SQLiteOpenHelper {

    public static final String DBNAME="mydb";
    public static final String TBNAME="mytable";
    public static final String ID="id";
    public static final String P_NAME="p_name";
    public static final String P_EMAIL="p_email";
    public static final String GENDER="gender";
    public static final String HOBBEY="hobbey";
    public static final int VERSION=1;

    public DBhelper(@Nullable Context context) {
        // In This construter will create database name
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE "+TBNAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + P_NAME
        +" TEXT," + P_EMAIL+" TEXT,"+ GENDER +" TEXT," +HOBBEY+" TEXT)";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(User user){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(P_NAME,user.getPerson_n());
        cv.put(P_EMAIL,user.getPerson_e());
        cv.put(GENDER,user.getPerson_gender());
        cv.put(HOBBEY,user.getPerson_hobbey());
        db.insert(TBNAME,ID,cv);
        db.close();
    }


    public List<User> Show(){
        ArrayList<User>arrayList= new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        String Column[]= {ID,P_NAME,P_EMAIL,GENDER,HOBBEY};
        Cursor c=db.query(TBNAME,Column,null,null,null,null,null);
        while (c.moveToNext()){

            int id=c.getInt(0);
            String p_Name=c.getString(1);
            String p_Email=c.getString(2);
            String gender=c.getString(3);
            String hobbey=c.getString(4);
            User  user=new User();
            user.setId(id);
            user.setPerson_n(p_Name);
            user.setPerson_e(p_Email);
            user.setPerson_gender(gender);
            user.setPerson_hobbey(hobbey);
            arrayList.add(user);
        }

        return arrayList;
    }

    public void update(@NonNull User user){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(P_NAME,user.getPerson_n());
        cv.put(P_EMAIL,user.getPerson_e());
        cv.put(GENDER,user.getPerson_gender());
        cv.put(HOBBEY,user.getPerson_hobbey());
        String where=ID + "="+user.getId();
        db.update(TBNAME,cv,where,null);
        db.close();
    }

    public void deletedata(int id){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        String where=ID + "="+id;
                db.delete(TBNAME,where,null);
                db.close();

    }
}



