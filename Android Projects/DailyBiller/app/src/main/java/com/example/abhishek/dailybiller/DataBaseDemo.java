package com.example.abhishek.dailybiller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ABHISHEK on 6/6/2016.
 */
public class DataBaseDemo {
    private static final String DATE="date";
    private static final String NAME="name";
    private static final String PRICE="price";
    private static final String NUMBER="no";
    private static final String AMOUNT="amount";
    private static final String TB_NAME="record";
    private static final String DB_NAME="anuj.db";
    private static final int VERSION=1;

    private static final String CREATE="create table record(date varchar(20),name varchar(30) primary key,price varchar(10),no varchar(5),amount varchar(10));";
    private Helper help;
    private SQLiteDatabase sd;

    DataBaseDemo(Context context){
        help=new Helper(context);
    }

    public void open(){
        sd=help.getWritableDatabase();

    }

    public long insert(DayDetails d){
        ContentValues cv=new ContentValues();
        cv.put("date",d.date);
        cv.put("name",d.name);
        cv.put("price",d.price);
        cv.put("no",d.no);
        cv.put("amount",d.amount);

        return sd.insert(TB_NAME, null, cv);

    }

public  List<DayDetails> getRecords(){
            Cursor c=sd.rawQuery("select * from record",null);
        ArrayList l=new ArrayList();

        while(c.moveToNext()){
            DayDetails day=new DayDetails();
            day.setDate(c.getString(0));
            day.setName(c.getString(1));
            day.setPrice(c.getFloat(2));
            day.setNo(c.getInt(3));
            day.setAmount(c.getFloat(4));
            l.add(day);
        }

       return l;
    }


  public DayDetails getByDate(String email)
  {
      Cursor c=sd.rawQuery("select * from record where date=?",new String[]{email});
      DayDetails day=null;
      if(c.moveToNext())
      {
           day=new DayDetails();
          day.setDate(c.getString(0));
          day.setName(c.getString(1));
          day.setPrice(c.getFloat(2));
          day.setNo(c.getInt(3));
          day.setAmount(c.getFloat(4));

      }

      return day;
  }

    public  List<DayDetails> findRecords(String em){
        Cursor c=sd.rawQuery("select * from record where email=?",new String[]{em});
        ArrayList l=new ArrayList();

        while(c.moveToNext()){
            DayDetails day=new DayDetails();
            day.setDate(c.getString(0));
            day.setName(c.getString(1));
            day.setPrice(c.getFloat(2));
            day.setNo(c.getInt(3));
            day.setAmount(c.getFloat(4));
            l.add(day);
        }

        return l;
    }


public void close(){
    sd.close();
}


    public int delete(DayDetails day){
        return sd.delete(TB_NAME, "date= ?",new String[]{day.getDate()});
    }


    public boolean deleteAll()
    {
        sd.delete(TB_NAME, null, null);
        return true;
    }


    private class Helper extends SQLiteOpenHelper{

        public Helper(Context context) {
            super(context, DB_NAME, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}

