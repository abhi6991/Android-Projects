package com.example.bankingdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CollegeCourses extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_college_courses);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_college_courses, menu);
		return true;
	}

}
