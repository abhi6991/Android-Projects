package com.example.clickonpairbluetooth;

import java.util.ArrayList;
import java.util.Set;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Bluetooth3Activity extends Activity {
	BluetoothDevice device;
	TextView tv1;
	ListView lv1;
	ArrayList al;
	ArrayAdapter aad;
	private static final int REQUEST_ENABLE_BT =1;
	protected static final String EXTRA_ADDRESS = null;
	BluetoothAdapter btAdapter;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1= (TextView)findViewById(R.id.textView1);
        lv1= (ListView)findViewById(R.id.listView1);
        btAdapter = BluetoothAdapter.getDefaultAdapter();
        tv1.append("\nAdapter:" +btAdapter);
        al= new ArrayList();
        aad = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,al);
        CheckBluetoothState();
    }

protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	// TODO Auto-generated method stub
	super.onActivityResult(requestCode, resultCode, data);
	if(requestCode==REQUEST_ENABLE_BT)
	{
		  CheckBluetoothState();
}
 }


 private void CheckBluetoothState(){
	 if(btAdapter==null)
	 {
		 tv1.append("\nBluetooth is not supported.");
		 return ;
		 
	 }
 
	 else
	 {
		 if(btAdapter.isEnabled())
		 {
			 tv1.append("\nBluetooth is enabled.");
			 tv1.append("\nPaired devices are:");
			 Set<BluetoothDevice> devices = btAdapter.getBondedDevices();
			 for(BluetoothDevice device : devices)
			 {
				/* tv1.append("\n Device:" +device.getName() + "," + device);*/
			     al.add(device.getName()+"\n"+device.getAddress());
			     lv1.setAdapter(aad);
			 }
			 lv1.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View v,
						int arg2, long arg3) {
					
					String info = ((TextView)v).getText().toString();
					//String address = info.substring(info.length());
					Log.e("Deep addreasa is ",info);
					Intent i = new Intent(getApplicationContext(),ledcontrol.class);
	                 i.putExtra(EXTRA_ADDRESS,info);   
					startActivity(i);
				}
			  });
		 }
		 else
		 {
			 Intent in = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			 startActivityForResult(in,REQUEST_ENABLE_BT);
		 }
	 }
 }
}
