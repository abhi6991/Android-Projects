package com.example.calculatorusingwebservices;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
Button b;
EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(EditText)findViewById(R.id.editText1);
        t2=(EditText)findViewById(R.id.editText2);
    b=(Button)findViewById(R.id.button1);
    
    
    b.setOnClickListener(new  OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			/*int i=Integer.parseInt(t1.getText().toString());
			int j=Integer.parseInt(t2.getText().toString());
			
			WebData d=new WebData();
			String data=d.getAdd("add", i, j);
			Toast.makeText(getApplicationContext(), data, 1000).show();
			*/
			String name=t1.getText().toString();
			String pass=t2.getText().toString();
			
			WebData d=new WebData();
			String data=d.getReg("register", name,pass);
			Toast.makeText(getApplicationContext(), data, 1000).show();
			
		}
	});
    }


 
    
}
