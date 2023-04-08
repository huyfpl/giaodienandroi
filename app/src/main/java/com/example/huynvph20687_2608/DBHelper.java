package com.example.huynvph20687_2608;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "huytb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table ban(id integer primary key autoincrement,ten text,ngay text,phongban text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists ban");
        onCreate(db);
    }
    public boolean insert(ban b){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("ten",b.getTen());
        values.put("ngay",b.getNgay());
        values.put("phongban",b.getPhongban());
        long kq=db.insert("ban",null,values);
        return kq>0;
    }
    public boolean update(ban b){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("ten",b.getTen());
        values.put("ngay",b.getNgay());
        values.put("phongban",b.getPhongban());
        long kq=db.update("ban",values,"id=?",new String[]{b.getId()+""});
        return kq>0;
    }
    public boolean delete(int id){
        SQLiteDatabase db=getWritableDatabase();
        long kq=db.delete("ban","id=?",new String[]{id+""});
        return kq>0;
    }
    public ArrayList<ban> selectall(){
        ArrayList<ban> list=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        String sql="select * from ban";
        Cursor cs=db.rawQuery(sql,null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            ban b=new ban();
            b.setId(cs.getInt(0));
            b.setTen(cs.getString(1));
            b.setNgay(cs.getString(2));
            b.setPhongban(cs.getString(3));
            list.add(b);
            cs.moveToNext();

        }
        return list;
    }
}
