package com.example.bankingdemo;
import java.util.Calendar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddTransaction extends Activity {
	private Spinner spinnerAccounts;
	private TextView textTransDate;
	private int day, month, year;
	
	EditText editTransAmount,editChequeNo,editChequeParty,editChequeDetails,editRemarks;



	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_transaction);
		
		spinnerAccounts = (Spinner) this.findViewById(R.id.spinnerAccounts);
		Database.populateAccounts(spinnerAccounts);
		textTransDate = (TextView) this.findViewById(R.id.textTransDate);
		 // get the current date
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        updateDateDisplay();
       
	}

            
	@Override 
	public void onStart() {
		super.onStart();
		
	}


	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return Utils.inflateMenu(this,menu);
	}
	
	@Override 
	public boolean onOptionsItemSelected(MenuItem item) {
		return  Utils.handleMenuOption(this,item);
	}
	
	private void updateDateDisplay() {
            // Month is 0 based so add 1
	        textTransDate.setText( String.format("%d-%d-%d",year,month + 1,day));
	}
	 
	public void addTransaction(View v) {
		// get access to views
				String accountId = Database.getAccountId(spinnerAccounts);
				RadioButton  radioDeposit = (RadioButton) this.findViewById(R.id.radioDeposit);
				
				editTransAmount = (EditText) this.findViewById(R.id.editTransAmount);
				editChequeNo = (EditText) this.findViewById(R.id.editChequeNo);
				editChequeParty = (EditText) this.findViewById(R.id.editChequeParty);
				editChequeDetails = (EditText) this.findViewById(R.id.editChequeDetails);
				editRemarks = (EditText) this.findViewById(R.id.editRemarks);

				boolean check = CheckValidations();
				if(check == true)
				{
				boolean done = Database.addTransaction(this,
						accountId,
						radioDeposit.isChecked() ? "d" : "w",   // trans type 
						textTransDate.getText().toString(),
						editTransAmount.getText().toString(),
						editChequeNo.getText().toString(),
						editChequeParty.getText().toString(),
						editChequeDetails.getText().toString(),
						editRemarks.getText().toString());
				
				if ( done )
				{
				
					Toast.makeText(this,"Added Transaction Successfully!", Toast.LENGTH_LONG).show();
					this.finish();
				}
				else
					Toast.makeText(this, "Sorry Could Not Add Transaction!", Toast.LENGTH_LONG).show();
				}
				else 
					return;
	} // addDeposit


	private boolean CheckValidations() {
		// TODO Auto-generated method stub
		
		//EditText editTransAmount,editChequeNo,editChequeParty,editChequeDetails,editRemarks;
		if(editTransAmount.getText().toString().length()==0){
			editTransAmount.setError("Transaction amount cannot be empty");
			return false;
		}
		if(editChequeNo.getText().toString().length()==0){
			editChequeNo.setError("Check Number cannot be empty");
			return false;
		}
		if(editChequeParty.getText().toString().length()==0){
			editChequeParty.setError("Cheque Party cannot be empty");
			return false;
		}
		if(editChequeDetails.getText().toString().length()==0){
			editChequeDetails.setError("Cheque Details cannot be empty");
			return false;
		}
		if(editChequeDetails.getText().toString().length()==0){
			editChequeDetails.setError("Cheque Details cannot be empty");
			return false;
		}
		return true;
	}
	

}
