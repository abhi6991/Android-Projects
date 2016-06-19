package deep.ducat.java.demo;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
Button submit;
EditText name,pass,course,fname;
TextView t;
Spinner date,month,year;
ImageButton imgn,imgp,imgc,imgf;
private static final int NAME=1;
private static final int PASS=2;
private static final int CNAME=3;
private static final int FNAME=4;
Typeface tf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String fontPath = "fonts/AlexBrush-Regular.ttf";      
   tf=Typeface.createFromAsset(getAssets(),fontPath);
    
    date=(Spinner)findViewById(R.id.spinner1);
    month=(Spinner)findViewById(R.id.spinner2);
    year=(Spinner)findViewById(R.id.spinner3);
    
    imgn=(ImageButton)findViewById(R.id.imageButton1);
    imgp=(ImageButton)findViewById(R.id.imageButton2);
    imgc=(ImageButton)findViewById(R.id.imageButton3);
    imgf=(ImageButton)findViewById(R.id.imageButton4);
    
    imgn.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			speakOut(NAME);
			
		}
	});
imgp.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			speakOut(PASS);
			
		}
	});
imgc.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		speakOut(CNAME);
		
	}
});
imgf.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		speakOut(FNAME);
		
	}
});
    
    name=(EditText)findViewById(R.id.editText1);
    pass=(EditText)findViewById(R.id.editText2);
    course=(EditText)findViewById(R.id.EditText011);
    fname=(EditText)findViewById(R.id.EditText012);
    
    t=(TextView)findViewById(R.id.textView1);
    
    submit=(Button)findViewById(R.id.button1);
    
    name.setTypeface(tf);
    pass.setTypeface(tf);
    course.setTypeface(tf);
    fname.setTypeface(tf);
    
    
    t.setTypeface(tf);
    
    submit.setTypeface(tf);
    
    getvalues();
    
    }

	private void getvalues() {
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(valid()){
					
				}
				
			}
		});
		
	}

	private boolean valid() {
		if(name.getText().toString().equals("")){
			alertMessage("Please fill name");
			return false;
		}else if(pass.getText().toString().equals("")){
			alertMessage("Please fill pass");
			return false;
		}else if(course.getText().toString().equals("")){
			alertMessage("Please fill course");
			return false;
		}else if(fname.getText().toString().equals("")){
			alertMessage("Please fill Father name");
			return false;
			}else {
				return true;
			}
	}
	private void alertMessage(String msg){
		AlertDialog.Builder a=new AlertDialog.Builder(MainActivity.this);
		a.setIcon(R.drawable.war);
		a.setTitle("Warning Message");
		a.setMessage(msg);
		a.setNeutralButton("Okey", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				//nothing....
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
        case NAME:
            if (resultCode == RESULT_OK && null != data) {
 
                ArrayList<String> text = data
                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
 
                name.setText(text.get(0));
            }
            break;
            
        case PASS:
        	if (resultCode == RESULT_OK && null != data) {
        		 
                ArrayList<String> text = data
                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
 
                pass.setText(text.get(0));
            }
            break;
        case CNAME:
        	if (resultCode == RESULT_OK && null != data) {
        		 
                ArrayList<String> text = data
                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
 
                course.setText(text.get(0));
            }
            break;
        case FNAME:
        	if (resultCode == RESULT_OK && null != data) {
        		 
                ArrayList<String> text = data
                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
 
                fname.setText(text.get(0));
            }
            break;
 
        }
    }
    
}
