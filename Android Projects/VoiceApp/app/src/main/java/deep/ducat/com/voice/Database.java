package deep.ducat.com.voice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database {
	
	Helper h;
	SQLiteDatabase sd;
	
public Database(Context ctx){
	h=new Helper(ctx);	
}

public void open(){
	sd=h.getWritableDatabase();	
}

public long insert(Student std){
	ContentValues c=new ContentValues();
	c.put("name", std.getName());
	c.put("course", std.getCourse());
	c.put("email", std.getEmail());
	c.put("fname", std.getFathername());
	c.put("pass", std.getPassword());
	c.put("roll", std.getRoll());
	c.put("mobile", std.getMobile());
	c.put("dob",std.getDob());
	return sd.insert("data", null,c);
}

public Cursor getAllData(){
	return sd.rawQuery("select * from data",null);
}

public Student getStudent(String roll){
	Cursor c=sd.rawQuery("select * from data where roll = ?", new String[]{roll});
	if(c.moveToNext()){
		Student s=new Student();	
    	s.setName(c.getString(0));
    	s.setCourse(c.getString(1));
    	s.setEmail(c.getString(2));
    	s.setFathername(c.getString(3));
    	s.setPassword(c.getString(4));
    	s.setRoll(roll);
    	s.setMobile(c.getString(6));
    	s.setDob(c.getString(7));
   return s;
	}else{
		return null;	
	}
    
}

public void close(){
	sd.close();
}

private class Helper extends SQLiteOpenHelper{

	public Helper(Context context) {
		super(context, "ipec", null, 1);	
	}
	@Override
	public void onCreate(SQLiteDatabase sd) {
		sd.execSQL("create table data (name varchar(20),course varchar(10),email varchar(20),fname varchar(20),pass varchar(20),roll varchar(10) primary key,mobile varchar(10),dob varchar(10));");	
	}
	@Override
	public void onUpgrade(SQLiteDatabase sd, int arg1, int arg2) {
		sd.execSQL("drop table if exist data");
		onCreate(sd);
	}
	
}


}
