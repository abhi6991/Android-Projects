package com.example.bankingdemo;



import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CollegeDetails extends Activity {
Button btncourses,btnstdlgn,btnplcmnt,btncntct,btnclgweb;
String uri = "http://www.sharda.ac.in/student-testimonial/";
String uri2 ="http://www.sharda.ac.in/";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_college_details);
		
		
		btncourses = (Button) findViewById(R.id.button1);
		btnstdlgn = (Button) findViewById(R.id.button2);
		btnplcmnt = (Button) findViewById(R.id.button3);
		btncntct = (Button) findViewById(R.id.button4);
		btnclgweb = (Button) findViewById(R.id.button5);
		
		
		btncourses.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in = new Intent();
				in.setClass(CollegeDetails.this,CollegeCourses.class);
				startActivity(in);
				//finish();
				
			}
		});
		btnstdlgn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent	in=new Intent(Intent.ACTION_VIEW,Uri.parse(uri));
				startActivity(in);
			}
		});
		
		btnplcmnt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent();
				in.setClass(CollegeDetails.this,CollegePlacements.class);
				startActivity(in);
				//finish();
				
			}
		});
		
		btncntct.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent();
				in.setClass(CollegeDetails.this,CollegeContact.class);
				startActivity(in);
			//	finish();
			}
		});
		btnclgweb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent	in=new Intent(Intent.ACTION_VIEW,Uri.parse(uri2));
				startActivity(in);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_college_details, menu);
		return true;
	}

}
