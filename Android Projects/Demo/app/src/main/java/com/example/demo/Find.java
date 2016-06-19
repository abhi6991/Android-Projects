package com.example.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class Find extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.find);
		AutoCompleteTextView ac=(AutoCompleteTextView)findViewById(R.id.ac1);
		Database db=new Database(getApplicationContext());
		db.open();
		ac.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,db.getRecord()));
		ac.setThreshold(1);
		db.close();
	}

}
