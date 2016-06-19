package com.example.abhishek.menuexample1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends Activity {
EditText t1,t2,t3,t4;
Button b1,b2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		t1=(EditText)findViewById(R.id.re1);
		t2=(EditText)findViewById(R.id.re2);
		t3=(EditText)findViewById(R.id.re3);
		t4=(EditText)findViewById(R.id.re4);
		
		
		b1=(Button)findViewById(R.id.rb1);
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				DatabaseDemo d=new DatabaseDemo(getApplicationContext());
				d.open();
				User u=new User();
				u.setEmail(t1.getText().toString());
				u.setPass(t2.getText().toString());
				u.setName(t3.getText().toString());
				u.setPhone(t4.getText().toString());
				
				if(d.insert(u)>0){
					Toast.makeText(getApplicationContext(), "success", 1000).show();
				}
				d.close();
				
				
			}
		});
		
	}
	
}
