package com.example.bankingdemo;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class StartingPoint extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// full screen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.starting_point);

		Thread t = new Thread() {
			public void run() {
				try {
					sleep(2500);

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					Intent intent = new Intent(StartingPoint.this, Login.class);
				     finish();
					startActivity(intent);

				}

			}

		};
		t.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.starting_point, menu);
		return true;
	}

}
