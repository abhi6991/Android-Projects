package com.example.demo;

import java.net.ContentHandler;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Database {
	
	private final String NAME="name";
	private final String PASS="pass";
	private final String EMAIL="email";
	private final String PHONE="phone";
	private final static String DB_NAME="aayush";
	private final String TB_NAME="user";
	private final static int VERSION=1;
	Helper h;
	SQLiteDatabase sd;
private final String CREATE="create table user(name varchar(20),pass varchar(20),email varchar(20) primary key,phone varchar(20));";
			public Database(Context context)
			 {
				h=new Helper(context);
			 
	           	
	           
		// TODO Auto-generated constructor stub
	}

public void open()
{
	sd=h.getWritableDatabase();
}
public void close()
{
	sd.close();
}
public long insert(User u)
{
	 ContentValues cv=new ContentValues();
	 cv.put(NAME, u.getName());
	 cv.put(PASS, u.getPass());
	 cv.put(EMAIL, u.getEmail());
	 cv.put(PHONE, u.getPhone());
	return sd.insert(TB_NAME, null, cv); 
}

public boolean login(User u)
{
Cursor c=	sd.rawQuery("select * from user where email=?and pass=?" , new String[]{u.getEmail(),u.getPass()} );
if(c.moveToNext())
{
	return true;
}
else
{
	return false;
}
}
public boolean isEmailD(User u)
{
Cursor c=	sd.rawQuery("select * from user where email=?" , new String[]{u.getEmail()} );
if(c.moveToNext())
{
	return true;
}
else
{
	return false;
}
} 

public List<User> getRecord()
{
	Cursor c=sd.rawQuery("select * from user", null);
	ArrayList a=new ArrayList();
	while(c.moveToNext())
	{
		User u=new User();
		u.setName(c.getString(0));
		u.setPass(c.getString(1));
		u.setEmail(c.getString(2));
		u.setPhone(c.getString(3));
		a.add(u);
	}
	return a;
	
}
public int delete(User u){
	return sd.delete(TB_NAME, "email= ?",new String[]{u.getEmail()});
}
public boolean deleteAll()
{
	sd.delete(TB_NAME, null, null);
	return true;
}

	public int update(User u){
		ContentValues cv=new ContentValues();
		cv.put(EMAIL, u.getEmail());
		cv.put(PASS,u.getPass());
		return sd.update(TB_NAME, cv, "email = ?", new String[]{u.getEmail()});
	}

public int delete(String email){
	return sd.delete(TB_NAME, "email = ?", new String[]{email});
}


private class Helper extends SQLiteOpenHelper
{
	public Helper(Context context
			) {
		super(context, DB_NAME, null, VERSION);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		arg0.execSQL(CREATE);
	}



	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
	}
	}
}
