package com.example.abhishek.menuexample1;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseDemo {
	
	private final static String EMAIL="email";
	private final static String PASS="pass";
	private final static String NAME="name";
	private final static String PHONE="phone";
	
	private final static String DB_NAME="aayush.db";
	private final static String TB_NAME="user";
	
	private static final int VERSION=1;
	
	private final static String CREATE="create table '"+TB_NAME+"' (email varchar(30) primary key,pass varchar(20),name varchar(20),phone varchar(10));";
	private Helper help;
	private SQLiteDatabase sd;
	public DatabaseDemo(Context context){
		help=new Helper(context);
		
	}
	
	public void open(){
		sd=help.getWritableDatabase();
	}
	
	public long insert(User u){
		ContentValues cv=new ContentValues();
		cv.put(EMAIL, u.getEmail());
		cv.put(PASS, u.getPass());
		cv.put(NAME, u.getName());
		cv.put(PHONE, u.getPhone());
		return sd.insert(TB_NAME, null, cv);
	}
	
	public boolean login(User u){
		Cursor c=sd.rawQuery("select * from user where email = ? and pass = ?",new String[]{u.getEmail(),u.getPass()});
	if(c.moveToNext()){
		return true;
	}else{
		return false;
	}
	}
	public List<User> getRecords(){
		Cursor c=sd.rawQuery("select * from user",null);
		ArrayList<User> a=new ArrayList<User>();
		while(c.moveToNext()){
			User u=new User();
			u.setEmail(c.getString(0));
			u.setPass(c.getString(1));
			u.setName(c.getString(2));
			u.setPhone(c.getString(3));
			
			a.add(u);
		}
		return a;
	}
	public void close(){
		sd.close();
	}
	
	private class Helper extends SQLiteOpenHelper{

		public Helper(Context context) {
			super(context, DB_NAME, null,VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase arg0) {
		arg0.execSQL(CREATE);
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
			//
			
		}
		
		
		
	}
	
	
	
	

}
