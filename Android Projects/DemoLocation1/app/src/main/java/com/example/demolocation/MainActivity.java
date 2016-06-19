package com.example.demolocation;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   		t1=(TextView)findViewById(R.id.textView1);
   		t2=(TextView)findViewById(R.id.textView2);
        LocationManager lm=(LocationManager)getSystemService(LOCATION_SERVICE);
		LocationListener ll=new MyLocationListener();
   		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,ll);

   TelephonyManager t=(TelephonyManager)getSystemService(TELEPHONY_SERVICE);
		String s=t.getSimOperatorName().toString();
    Toast.makeText(this,getEmail(this)+" "+s,2000).show();
    }

    private static String getEmail(Context context){
    	AccountManager ac=AccountManager.get(context);
    	Account acnt=getAccount(ac);
    	if(acnt==null){
    		return null;
    	}else{
    		return acnt.name;
    	}
    }

private static Account getAccount(AccountManager ac){
	Account[] accounts=ac.getAccountsByType("com.google");
	Account account;
	if(accounts.length>0){
	account=accounts[0];
	}else{
		account=null;
	}
	return account;
}

    class MyLocationListener implements LocationListener{

		@Override
		public void onLocationChanged(Location location) {

			if(location!=null){
				double lat=location.getLatitude();
				double lon=location.getLongitude();
				t1.setText("Latitude " + lat);
				t2.setText("Longitude " + lon);
			}
		}

		@Override
		public void onProviderDisabled(String arg0) {
			Toast.makeText(getApplicationContext(),"Please On your GPS",Toast.LENGTH_LONG).show();
		}

		@Override
		public void onProviderEnabled(String arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			// TODO Auto-generated method stub

		}

    }

}
