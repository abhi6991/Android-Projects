package com.example.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Forget extends Activity {
	EditText t1,t2,t3;
	Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forget);
		
		t2=(EditText)findViewById(R.id.fe2);
		t3=(EditText)findViewById(R.id.fe3);
		b1=(Button)findViewById(R.id.fb1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				User u=new User();
				
				Database db=new Database(getApplicationContext());
				
				db.open();
				String s1=getIntent().getExtras().getString("key");
				
				u.setEmail(s1);
				
			String s2=	t2.getText().toString();
			String s3=	t3.getText().toString();
			if(valid())
			{
				if(s2.equals(s3))
				{
			
					
			u.setPass(t2.getText().toString());
			
			
			int i=db.update(u);
			if(i>0){
				Toast.makeText(getApplicationContext(), "update successfully", 1000).show();
				t2.setText("");
				t3.setText("");
			}
			db.close();

				
			}
				else
				{
					t3.setError("password don't match");
					t3.requestFocus();
				}
			}
			}
		});
		
		
	}
	
public boolean valid()
{
	if(t2.getText().toString().equals(""))
	{
		t2.setError("please write the emal");
		t2.requestFocus();
		return false;
	}
	else if(t3.getText().toString().equals(""))
	{
		 t3.setError("write the password");
		 t3.requestFocus();
		 return false;
		
	}
	else
	{
		return true;
	}

}
}
