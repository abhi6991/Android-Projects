package com.example.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.R.color;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends Activity {
	EditText t1,t2,t3,t4;
	Database d;
	Pattern pattern;
	Matcher matcher;
	CheckBox c;

	static final String email="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		Button b=(Button)findViewById(R.id.rb1);
		Button b1=(Button)findViewById(R.id.rb2);
		t1=(EditText)findViewById(R.id.re1);
		t2=(EditText)findViewById(R.id.re2);
		t3=(EditText)findViewById(R.id.re3);
		t4=(EditText)findViewById(R.id.re4);
		c=(CheckBox)findViewById(R.id.checkBox1);
		
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 d=new Database(getApplicationContext());
	             User u=new User();
	             u.setName(t1.getText().toString());
	             u.setPass(t2.getText().toString());
	             u.setEmail(t3.getText().toString());
	             u.setPhone(t4.getText().toString());
	             d.open();
	             if(valid())
	             {
	            	 if(c.isChecked())
	         		{
	             if(d.insert(u)>0)
	             {
	            	 Toast.makeText(getApplicationContext(), "suceess", 1000).show();
	             }
	             else
	             {
	            	 Toast.makeText(getApplicationContext(), "invlid", 1000).show();
	             }
	         		}
	            	 else
	         		{
	         			Toast.makeText(getApplicationContext(), "Accept the term first", 1000).show();
	         			
	         		} 
	             }
			}
		});
		
		
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				
			}
		});
	}
	
public boolean valid()
{
	if(t1.getText().toString().equals(""))
	{
		t1.setError("please write the name");
		t1.requestFocus();
		return false;
	}
	else if(t2.getText().toString().equals(""))
	{
		 t2.setError("write the password");
		 t2.requestFocus();
		 return false;
		
	}
	else if(t3.getText().toString().equals(""))
	{
		 t3.setError("write the email");
		 t3.requestFocus();
		 return false;
	}
	else if(t4.getText().toString().equals(""))
	{
		 t4.setError("write phone number");
		 t4.requestFocus();
		 return false;
	}
	else if(!isValidEmail())
	{
		 t3.setError("write the email adress correctly");
		 t3.requestFocus();
		 return false;
	}
	else if(!isValidMobile(t4.getText().toString()))
	{
		 t4.setError("write the phone number in correct way");
		 t4.requestFocus();
		 return false;
	}
	else
		return true;
	}



private boolean isValidEmail() {
	pattern=Pattern.compile(email);
	matcher=pattern.matcher(t3.getText().toString());
	return matcher.matches();
}

private boolean isValidMobile(String phone)
{
	return android.util.Patterns.PHONE.matcher(phone).matches();
}
}


