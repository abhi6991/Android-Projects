package com.example.servicedemo;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service{

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	MediaPlayer mp;
	
	@Override
	public void onCreate() {
	
		mp=MediaPlayer.create(getApplicationContext(),R.raw.aa);
		try {
			mp.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		mp.start();
			Intent in=new Intent(getApplicationContext(),MyBroad.class);
			sendBroadcast(in);
		
	
		return START_STICKY;
	}
	
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(getApplicationContext(),"start",1000).show();
		mp.stop();
		
	}
	

}
