package com.example.alarmdemo;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
	Activity ac;
	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "Time is up!!!!.",
				Toast.LENGTH_LONG).show();

		// Vibrate the mobile phone
		/*Vibrator vibrator = (Vibrator) context
				.getSystemService(Context.VIBRATOR_SERVICE);
		vibrator.vibrate(2000);*/
		
		
		/*Uri alarmTone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
		Ringtone ringtoneAlarm = RingtoneManager.getRingtone(context.getApplicationContext(), alarmTone);
		ringtoneAlarm.play();*/
		//ringtoneAlarm.stop();

	}
	
}
