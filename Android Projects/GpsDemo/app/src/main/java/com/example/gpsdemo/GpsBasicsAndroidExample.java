package com.example.gpsdemo;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

public class GpsBasicsAndroidExample extends Activity implements LocationListener {
         
            private LocationManager locationManager;
             
            @Override
            protected void onCreate(Bundle savedInstanceState) {
             
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                 
                /********** get Gps location service LocationManager object ***********/
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                 
              
                 
                locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER,
                        3000,   // 3 sec
                        10, this);
                 
                
            }
             
    
            @Override
            public void onLocationChanged(Location location) {
                    
                String str = "Latitude: "+location.getLatitude()+"Longitude: "+location.getLongitude();
  
                Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
            }
         
            @Override
            public void onProviderDisabled(String provider) {
                 
             
                 
                Toast.makeText(getBaseContext(), "Gps turned off ", Toast.LENGTH_LONG).show();
            }
         
            @Override
            public void onProviderEnabled(String provider) {
                 
               
                 
                Toast.makeText(getBaseContext(), "Gps turned on ", Toast.LENGTH_LONG).show();
            }
         
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                // TODO Auto-generated method stub
                 
            }
   }