package com.example.bankingdemo;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener {
	
	EditText login, pass;
	Button enter, exit,clgbtn;
	TextView tvAuth;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		login = (EditText)findViewById(R.id.etLogin);
		pass = (EditText)findViewById(R.id.etPass);
		enter = (Button)findViewById(R.id.button_enter);
		exit = (Button)findViewById(R.id.button_exit);
		tvAuth = (TextView)findViewById(R.id.auth);
		clgbtn = (Button) findViewById(R.id.button1);
		clgbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent in = new Intent();
				in.setClass(Login.this, CollegeActivity.class);
				startActivity(in);
				
			}
		});
		tvAuth.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
		enter.setOnClickListener(this);
		exit.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.button_enter:
			String Login_id ,Password;
			Login_id = login.getText().toString();
			Password = pass.getText().toString();
			
			if((Login_id.contentEquals("Admin"))&&(Password.contentEquals("Admin")))
			{
				Intent i = new Intent(Login.this,ListAccounts.class);
				startActivity(i);
			}
			else
				Toast.makeText(this, "Invalid Login ID or Password", Toast.LENGTH_SHORT).show();
			break;
		case R.id.button_exit:
			this.finish();
			break;
			
		}
		
	}

}
