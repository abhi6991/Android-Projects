package com.example.clickonpairbluetooth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ledcontrol extends Activity implements OnClickListener{
	Button on;
	Button off;
	Button dissconnect;
	BluetoothAdapter  btAdapter;
	BluetoothSocket btSocket;
	BluetoothDevice remotlycontrol;
	private ProgressDialog  progress;
	private boolean isbtConnected= false;
	static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); // why
	 
String address=""; 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ledcontrol);
        Intent ledin=  getIntent();
       address= ledin.getStringExtra(Bluetooth3Activity.EXTRA_ADDRESS);
        on= (Button)findViewById(R.id.on);
        off= (Button)findViewById(R.id.off);
        dissconnect= (Button)findViewById(R.id.disconnect);
        btAdapter= BluetoothAdapter.getDefaultAdapter();
        on.setOnClickListener(this);
        off.setOnClickListener(this);
        dissconnect.setOnClickListener(this);
        
   // new ConnectBT().execute();
    }
   private class ConnectBT extends AsyncTask
    {
    	private boolean ConnectSucess = true;
    	
    	
    	protected void onPreExecute() {
    		progress = ProgressDialog.show(getApplicationContext(), "Connecting....","Please Wait");
    	}
    	@Override
    	protected Object doInBackground(Object... arg0)
    	{
    	   try
    		{
    			if((btSocket==null)||(!isbtConnected))
    			{
    				BluetoothDevice remotlycontrol= btAdapter.getRemoteDevice(address);
    			btSocket = remotlycontrol.createInsecureRfcommSocketToServiceRecord(myUUID);
    			btAdapter.getDefaultAdapter().cancelDiscovery();
    			}
    			
    		}
    		catch(IOException e)
    		{
    		ConnectSucess= false;	
    		}
    		return null;
    	}
    @Override
    protected void onPostExecute(Object result) {
    	super.onPostExecute(result);
    	if(!ConnectSucess)
    	{
    		msg("Connection failed Please try again.");
    		finish();
    	}
    	else
    	{
    		msg("Connected :) enjoy");
    		isbtConnected= true;
    	}
    	progress.dismiss();
    }
        
       
     
 }
   private void turnoffled()
   {
	   if(btSocket!=null)
	   {
		   try
		   {
			   btSocket.getOutputStream().write("TF".toString().getBytes());
		   }
		   catch(IOException e)
		   {
			   msg("ERROR");
		   }
	   }
   }
   private void Disconnect()
   {
	   if(btSocket!=null)
	   {
		   try
		   {
			   btSocket.close();
		   }
		   catch(IOException e)
		   {
			   msg("ERROR");
		   }
	   }
	   finish();
   }
   private void turnonled()
   {
	   if(btSocket!=null)
	   {
		   try
		   {
			   btSocket.getOutputStream().write("TO".toString().getBytes());
		   }
		   catch(IOException e)
		   {
			   msg("ERROR");
		   }
	   }
   }
   private void msg(String s)
   {
	   Toast.makeText(getApplicationContext(), s,Toast.LENGTH_LONG).show();
   }
@Override
public void onClick(View v) {
	if(v.getId()==R.id.on){
		turnonled();
		Toast.makeText(getApplicationContext(), "System is on",1000).show();
	}else if(v.getId()==R.id.off){
		turnoffled();
		Toast.makeText(getApplicationContext(), "System is off",1000).show();
	}else{
		Disconnect();
		Toast.makeText(getApplicationContext(), "System is disconnect",1000).show();
	}
	
}

}