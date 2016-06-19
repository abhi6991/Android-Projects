package com.example.fileexplorer;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
File ff[];
ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView) findViewById(R.id.listView1);
        File f=Environment.getExternalStorageDirectory();
        ff=f.listFiles();
        
        lv.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,ff));
    
    lv.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			if(ff[arg2].isDirectory()){
			lv.setAdapter(new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,ff[arg2].listFiles()));
			}
			
		}
	
    	
    });
        
    }


   
    
}
