package com.example.shareprefrencesexample;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {
	SharedPreferences sp;
	EditText t1,t2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		sp=getSharedPreferences("abhishek", MODE_PRIVATE);
t1=(EditText)findViewById(R.id.editText1);
t2=(EditText)findViewById(R.id.editText2);

Button b1=(Button)findViewById(R.id.login);
b1.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
	if(!t1.getText().toString().equals("")&&!t2.getText().toString().equals("")){
		Editor e=sp.edit();
		e.putString("uname",t1.getText().toString());
		e.putString("upass",t2.getText().toString());
        e.commit();
        Intent in=new Intent(getApplicationContext(),Home.class);
        startActivity(in);
	}
		
	}
});
		
		
	}
	
}
