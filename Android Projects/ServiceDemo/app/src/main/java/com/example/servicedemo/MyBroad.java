package com.example.servicedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class MyBroad extends BroadcastReceiver{

	
	
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Toast.makeText(arg0,"start",1000).show();
		
	}
	 

}
