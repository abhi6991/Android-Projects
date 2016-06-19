package com.example.alarmdemo;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	

	public void startAlert(View view) {
		EditText text = (EditText) findViewById(R.id.time);
		int i = Integer.parseInt(text.getText().toString());
		
		Intent intent = new Intent(this, MyBroadcastReceiver.class);
		
		PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 234324243, intent, 0);
		
		AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
		alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
				+ (i * 1000), pendingIntent);
		Toast.makeText(this, "Alarm set in " + i + " seconds",
				Toast.LENGTH_LONG).show();
	
		show(this);
	}
	private void show(Context context){
		AlertDialog.Builder a=new AlertDialog.Builder(context);
		a.setTitle("Error Message");
		a.setMessage("Loading...");
		a.show();
		
		
	}


}
