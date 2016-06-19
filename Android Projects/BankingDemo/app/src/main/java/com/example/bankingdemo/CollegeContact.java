package com.example.bankingdemo;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CollegeContact extends Activity {
Button gmapbtn;
String uri ="https://www.google.co.in/maps/preview?ie=UTF-8&fb=1&gl=in&cid=5219412196855244718&q=sharda+university&ei=sKnYU_yLFsLJuATmwIDYBw&ved=0CIkBEPwSMA4";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_college_contact);
		gmapbtn = (Button) findViewById(R.id.button1);
		
		
		gmapbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent	in=new Intent(Intent.ACTION_VIEW,Uri.parse(uri));
				startActivity(in);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_college_contact, menu);
		return true;
	}

}
