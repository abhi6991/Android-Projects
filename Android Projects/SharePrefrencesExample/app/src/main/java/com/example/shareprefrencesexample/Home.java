package com.example.shareprefrencesexample;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Home extends Activity {
SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		sp=getSharedPreferences("abhishek", MODE_PRIVATE);
		TextView tv=(TextView)findViewById(R.id.textView1);
		tv.setText(sp.getString("uname", ""));
		
		Button b1=(Button)findViewById(R.id.logout);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
           Editor e=sp.edit();
           e.remove("uname");
           e.remove("upass");
           e.commit();
           Intent in=new Intent(getApplicationContext(),Login.class);
           startActivity(in);
				
			}
		});
		
		
	}
	
}
