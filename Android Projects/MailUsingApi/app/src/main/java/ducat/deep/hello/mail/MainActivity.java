package ducat.deep.hello.mail;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
Button send;
EditText to,sub,msg;
Context context;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   to=(EditText)findViewById(R.id.editText1);
   sub=(EditText)findViewById(R.id.editText2);
   msg=(EditText)findViewById(R.id.editText3);
   send=(Button)findViewById(R.id.button1);
   context=getApplicationContext();
   
   send.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
	
		new MySendMail().execute();
		
	}
});
   
    }
   
class MySendMail extends AsyncTask<String,Object,Void>{
	private ProgressDialog statusDialog;

	@Override
	protected void onPreExecute() {
		statusDialog = new ProgressDialog(MainActivity.this);
		statusDialog.setMessage("Sending Mail...");
		statusDialog.setIndeterminate(false);
		statusDialog.setCancelable(false);
		statusDialog.show();
		super.onPreExecute();
	}
	
	@Override
	protected Void doInBackground(String... params) {
		String sender="ducatdeep@gmail.com";
		String subject=sub.getText().toString();
		String body=msg.getText().toString();
		String To=to.getText().toString();
		try{
		GMailSender g=new GMailSender(sender,"dcrogxtpnaqkarbo");
		g.sendMail(subject, body, sender, To);
		}catch (Exception e) {
			
		}
		return null;
	}
	
	@Override
	public void onProgressUpdate(Object... values) {
		statusDialog.setMessage("server is slow!");

	}
	@Override
	protected void onPostExecute(Void result) {
		statusDialog.dismiss();
		Toast.makeText(getApplicationContext(), "successfully Send!", 1000).show();
		super.onPostExecute(result);
	}
}
    
}
