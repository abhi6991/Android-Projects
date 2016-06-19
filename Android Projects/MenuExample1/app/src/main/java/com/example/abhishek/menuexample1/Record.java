package com.example.abhishek.menuexample1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class Record extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.record);
		ListView lv=(ListView)findViewById(R.id.listView1);
		DatabaseDemo d=new DatabaseDemo(this);
		d.open();

		lv.setAdapter(new CustomList(this,d.getRecords()));
		d.close();



	}

}
