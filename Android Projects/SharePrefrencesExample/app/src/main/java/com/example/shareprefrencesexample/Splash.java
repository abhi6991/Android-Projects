package com.example.shareprefrencesexample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new DeepTask().execute();
        
    
    }
    private class DeepTask extends AsyncTask<Void,Void,Void>{
ProgressDialog pd;
    	@Override
    	protected void onPreExecute() {
    pd=new ProgressDialog(Splash.this);
    pd.setTitle("Wait...");
    pd.setMessage("Please wait..");
    pd.show();
    		super.onPreExecute();
    	}
    	
		@Override
		protected Void doInBackground(Void... arg0) {
			SharedPreferences sp=getSharedPreferences("abhishek", MODE_PRIVATE);
			String name=sp.getString("uname", "");
			String pass=sp.getString("upass", "");
			
			if(name.equals("")&&pass.equals("")){
				Intent in=new Intent(Splash.this,Login.class);
				startActivity(in);
			}else{
				Intent in=new Intent(Splash.this,Home.class);
				startActivity(in);	
			}
			return null;
		}
		@Override
				protected void onPostExecute(Void result) {
				pd.dismiss();
				finish();
					super.onPostExecute(result);
				}
    	
    }
    


    
}
