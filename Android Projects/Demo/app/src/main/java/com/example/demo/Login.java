package com.example.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity{
	
	EditText t1,t2;
	Button b1,b2,b3;
	Database db;
	User u;
	/*Login()
	{
		
	}*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		t1=(EditText)findViewById(R.id.le1);
		t2=(EditText)findViewById(R.id.le2);
		b1=(Button)findViewById(R.id.lb1);
		b2=(Button)findViewById(R.id.lb2);
		b3=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 db=new Database(getApplicationContext());
				db.open();
			 u=new User();
				u.setEmail(t1.getText().toString());
				u.setPass(t2.getText().toString());
				if(valid())
				{
				if(db.login(u))
				{
					Toast.makeText(getApplicationContext(), "login",1000).show();
					
				}
				else
				{
					Toast.makeText(getApplicationContext(), "invalid", 1000).show();
				}
				db.close();
				}
				
				
				
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			t1.setText("");
			t2.setText("");
			}
		});
		b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 db=new Database(getApplicationContext());
				 u=new User();
				Log.e("1323", "2");
				if(isvalid())
				{
				if(isEmail())
						{
					Log.e("1323", "2");
					Log.e("1323", "2");
				Intent i=new Intent(getApplicationContext(),Forget.class);
				i.putExtra("key", t1.getText().toString());
				startActivity(i);
						}
				else
				{Log.e("1323", "2");
				     t1.setError("email not exist");
				     t1.requestFocus();
				}
				}
			}

		
		});
	}
	public boolean isEmail() {
		Log.e("1323", "2");
		db.open();
		Log.e("1323", "2");
		u.setEmail(t1.getText().toString());
		Log.e("1323", "2");
		if(db.isEmailD(u))
		{
			return true;
			
		}
		db.close();
		return false;
		
	}
public boolean valid()
{
	if(t1.getText().toString().equals(""))
	{
		t1.setError("please write the emal");
		t1.requestFocus();
		return false;
	}
	else if(t2.getText().toString().equals(""))
	{
		 t2.setError("write the password");
		 t2.requestFocus();
		 return false;
		
	}
	else
	{
		return true;
	}
}
public String e()
{
	return t1.getText().toString();
}
public boolean isvalid()
{
	if(t1.getText().toString().equals(""))
	{
		t1.setError("please write the emal");
		t1.requestFocus();
		return false;
	}
	return true;
}
}
