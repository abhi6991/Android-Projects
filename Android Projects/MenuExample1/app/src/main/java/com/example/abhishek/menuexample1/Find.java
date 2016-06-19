package com.example.abhishek.menuexample1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class Find extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.find);
		AutoCompleteTextView ac=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
		DatabaseDemo d=new DatabaseDemo(this);
		d.open();
		ac.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,d.getRecords()));
		ac.setThreshold(1);


	}
	
}
