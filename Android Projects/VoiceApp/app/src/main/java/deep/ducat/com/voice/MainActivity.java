package deep.ducat.com.voice;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
EditText e1,e2,e3,e4,e5,e6,e7;
TextView t1;
Button b1;
Typeface tf;
Spinner sp1,sp2,sp3;
Database db;
ImageButton img1,img2,img3,img4,img5,img6,img7;

private static final int NAME=1;
private static final int COURSE=2;
private static final int EMAIL=3;
private static final int FATHERNAME=4;
private static final int PASS=5;
private static final int ROLL=6;
private static final int MOBILE=7;

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        String path="fonts/Sail-Regular.otf"; 
        tf=Typeface.createFromAsset(getAssets(), path);
        
        e1=(EditText)findViewById(R.id.EditText1);
        e2=(EditText)findViewById(R.id.EditText2);
        e3=(EditText)findViewById(R.id.EditText3);
        e4=(EditText)findViewById(R.id.editText4);
        e5=(EditText)findViewById(R.id.editText5);
        e6=(EditText)findViewById(R.id.EditText6);
        e7=(EditText)findViewById(R.id.EditText7);
        
        t1=(TextView)findViewById(R.id.textView1);
        b1=(Button)findViewById(R.id.button1);
        img1=(ImageButton)findViewById(R.id.ImageButton1);
        img2=(ImageButton)findViewById(R.id.ImageButton2);
        img3=(ImageButton)findViewById(R.id.ImageButton3);
        img4=(ImageButton)findViewById(R.id.imageButton4);
        img5=(ImageButton)findViewById(R.id.imageButton5);
        img6=(ImageButton)findViewById(R.id.imageButton6);
        img7=(ImageButton)findViewById(R.id.imageButton7);
        
        sp1=(Spinner)findViewById(R.id.spinner1);
        sp2=(Spinner)findViewById(R.id.spinner2);
        sp3=(Spinner)findViewById(R.id.spinner3);
        
        setFonts();
        db=new Database(getApplicationContext());
        b1.setOnClickListener(this);
        
        img1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			speakOut(1);
				
			}
		});
img2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			speakOut(2);
				
			}
		});
img3.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
	speakOut(3);	
	}
});
img4.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
	speakOut(4);
		
	}
});
img5.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
	speakOut(5);
		
	}
});
img6.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
	speakOut(6);	
	}
});
img7.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
	speakOut(7);
		
	}
});
    }

	private void setFonts() {
		e1.setTypeface(tf);
		e2.setTypeface(tf);
		e3.setTypeface(tf);
		e4.setTypeface(tf);
		e5.setTypeface(tf);
		e6.setTypeface(tf);
		e7.setTypeface(tf);
		t1.setTypeface(tf);
		b1.setTypeface(tf);
			
	}

	@Override
	public void onClick(View arg0) {
		if(valid()){
			try{
				db.open();
				Student s=new Student();
				s.setName(e1.getText().toString());
				s.setCourse(e2.getText().toString());
				s.setEmail(e3.getText().toString());
				s.setFathername(e4.getText().toString());
				s.setPassword(e5.getText().toString());
				s.setRoll(e6.getText().toString());
				s.setMobile(e7.getText().toString());
				String dob=sp1.getSelectedItem().toString()+"-"+sp2.getSelectedItem().toString()+"-"+sp3.getSelectedItem().toString();
				s.setDob(dob);
				Log.e("demo 1",s.toString());
				long id=db.insert(s);
				Log.e("demo 1",String.valueOf(id));
				if(id>1){
					Toast.makeText(getApplicationContext(),"Successfully Registered", 1000).show();
					
				}
				db.close();
				
			}
			catch (Exception e) {
				alertMessage(e.toString());
				db.close();
			}
		}
		
	}
	
	private boolean valid(){
		if(e1.getText().toString().equals("")){
			alertMessage("Please Enter Name !");
			e1.requestFocus();
			return false;
		}else if(e2.getText().toString().equals("")){
			alertMessage("Please Enter Course !");
			e2.requestFocus();
			return false;
		}else if(e3.getText().toString().equals("")){
			alertMessage("Please Enter Email Id !");
			e3.requestFocus();
			return false;
		}else if(e4.getText().toString().equals("")){
			alertMessage("Please Enter Father Name !");
			e4.requestFocus();
			return false;
		}else if(e5.getText().toString().equals("")){
			alertMessage("Please Enter Password !");
			e5.requestFocus();
			return false;
		}else if(e6.getText().toString().equals("")){
			alertMessage("Please Enter Roll Number !");
			e6.requestFocus();
			return false;
		}else if(e7.getText().toString().equals("")){
			alertMessage("Please Enter Mobile !");
			e7.requestFocus();
			return false;
		}else if(sp1.getSelectedItem().toString().equals("Date")){
			alertMessage("Please Select Date !");
			sp1.requestFocus();
			return false;
		}else if(sp2.getSelectedItem().toString().equals("Month")){
			alertMessage("Please Select Month !");
			sp2.requestFocus();
			return false;
		}else if(sp3.getSelectedItem().toString().equals("Year")){
			alertMessage("Please Select Year !");
			sp3.requestFocus();
			return false;
		}else{
			return true;
		}
	}

	private void alertMessage(String msg) {
		AlertDialog.Builder a=new AlertDialog.Builder(MainActivity.this);
		a.setTitle("Warning Message !");
		a.setIcon(R.drawable.war);
		a.setMessage(msg);
		a.setNeutralButton("Okey", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				
			}
		});
		a.show();
		
	}
	 private void speakOut(int resultcode){
	    	Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	    	intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
	        try {
	           startActivityForResult(intent, resultcode);
	        } catch (ActivityNotFoundException a) {
	            Toast t = Toast.makeText(getApplicationContext(),
	                    "Opps! Your device doesn't support Speech to Text",
	                    Toast.LENGTH_SHORT);
	            t.show();
	        }

	    }
	    

	    @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);
	 
	        switch (requestCode) {
	        case 1:
	            if (resultCode == RESULT_OK && null != data) {
	 
	                ArrayList<String> text = data
	                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
	 
	                e1.setText(text.get(0));
	            }
	            break;
	            
	        case 2:
	        	if (resultCode == RESULT_OK && null != data) {
	        		 
	                ArrayList<String> text = data
	                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
	 
	                e2.setText(text.get(0));
	            }
	            break;
	        case 3:
	        	if (resultCode == RESULT_OK && null != data) {
	        		 
	                ArrayList<String> text = data
	                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
	 
	                e3.setText(text.get(0));
	            }
	            break;
	        case 4:
	        	if (resultCode == RESULT_OK && null != data) {
	        		 
	                ArrayList<String> text = data
	                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
	 
	                e4.setText(text.get(0));
	            }
	            break;
	        case 5:
	        	if (resultCode == RESULT_OK && null != data) {
	        		 
	                ArrayList<String> text = data
	                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
	 
	                e5.setText(text.get(0));
	            }
	            break;
	        case 6:
	        	if (resultCode == RESULT_OK && null != data) {
	        		 
	                ArrayList<String> text = data
	                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
	 
	                e6.setText(text.get(0));
	            }
	            break;
	        case 7:
	        	if (resultCode == RESULT_OK && null != data) {
	        		 
	                ArrayList<String> text = data
	                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
	 
	                e7.setText(text.get(0));
	            }
	            break;
	        }
	    }
	    @Override
	    	public boolean onCreateOptionsMenu(Menu menu) {
	 
	    		return super.onCreateOptionsMenu(menu);
	    	}
}
