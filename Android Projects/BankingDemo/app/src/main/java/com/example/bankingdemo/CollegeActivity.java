package com.example.bankingdemo;




import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;


public class CollegeActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_college);
		 TabHost tabHost = getTabHost();
	        
	        
	        TabSpec clgdetspec = tabHost.newTabSpec("College Details");
	        clgdetspec.setIndicator("College Details", getResources().getDrawable(R.drawable.rounded));
	        Intent detIntent = new Intent(this, CollegeDetails.class);
	        clgdetspec.setContent(detIntent);
	        
	        
	        TabSpec aboutusspec = tabHost.newTabSpec("About Us");
	        
	        aboutusspec.setIndicator("About Us", getResources().getDrawable(R.drawable.rounded));
	        Intent aboutIntent = new Intent(this, AboutUs.class);
	        aboutusspec.setContent(aboutIntent);
	        tabHost.addTab(clgdetspec);
	        tabHost.addTab(aboutusspec);
	        
	       
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_college, menu);
		return true;
	}

}
