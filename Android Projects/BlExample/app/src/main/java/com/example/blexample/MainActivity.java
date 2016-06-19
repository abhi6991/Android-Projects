package com.example.blexample;

import java.util.Iterator;
import java.util.Set;

import android.os.Bundle;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	BluetoothAdapter btAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public void on(View v){
    	if(!btAdapter.isEnabled()){
    		btAdapter.enable();
    	}
    }
   public void off(View v){
    	if(btAdapter.isEnabled()){
    		btAdapter.disable();
    	}
    }
   
   public void bonded(View v){
	 if(btAdapter.isEnabled()){
		 Set s= btAdapter.getBondedDevices();
		  Iterator it=s.iterator();
		  while(it.hasNext()){
			  BluetoothDevice b=(BluetoothDevice)it.next();
			  Toast.makeText(getApplicationContext(),b.getName(), 500).show();
		  }
	 }
	  
   }

   
    
}
