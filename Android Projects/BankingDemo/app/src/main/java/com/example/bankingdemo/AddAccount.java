package com.example.bankingdemo;



import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddAccount extends Activity {
	
	EditText editAcno, editCno, editHolders, editBankName, editBranchName, editAddress, editIFSC, editMICR, editBalance, editRemarks;
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.addaccount);
	    }
	 
	 
	 @Override
		public boolean onCreateOptionsMenu(Menu menu) {
			return Utils.inflateMenu(this,menu);
		}
		
		@Override 
		public boolean onOptionsItemSelected(MenuItem item) {
			return  Utils.handleMenuOption(this,item);
		}
		
	  public void addAccount(View v) {
		    // get access to views
		  
		    editAcno = (EditText) this.findViewById(R.id.editAcno);
		    editCno = (EditText) this.findViewById(R.id.editCno);
		    editHolders = (EditText) this.findViewById(R.id.editHolders);
		    editBankName = (EditText) this.findViewById(R.id.editBankName);
		    editBranchName = (EditText) this.findViewById(R.id.editBranchName);
		    editAddress = (EditText) this.findViewById(R.id.editAddress);
		    editIFSC = (EditText) this.findViewById(R.id.editIFSC);
		    editMICR = (EditText) this.findViewById(R.id.editMICR);
		    editBalance = (EditText) this.findViewById(R.id.editBalance);
		    editRemarks = (EditText) this.findViewById(R.id.editRemarks);
		     
		    boolean check = CheckValidations();
		    if(check == true){
			try {
				DBHelper dbhelper = new DBHelper(this); 
				SQLiteDatabase db = dbhelper.getWritableDatabase();
                Log.d("Account","Got Writable database");
				// execute insert command

				ContentValues values = new ContentValues();
				values.put( Database.ACCOUNTS_ACNO, editAcno.getText().toString());
				values.put( Database.ACCOUNTS_CNO, editCno.getText().toString());
				values.put( Database.ACCOUNTS_HOLDERS, editHolders.getText().toString());
				values.put( Database.ACCOUNTS_BANK, editBankName.getText().toString());
				values.put( Database.ACCOUNTS_BRANCH, editBranchName.getText().toString());
				values.put( Database.ACCOUNTS_ADDRESS, editAddress.getText().toString());
				values.put( Database.ACCOUNTS_IFSC, editIFSC.getText().toString());
				values.put( Database.ACCOUNTS_MICR, editMICR.getText().toString());
				values.put( Database.ACCOUNTS_BALANCE, editBalance.getText().toString());
				values.put( Database.ACCOUNTS_REMARKS, editRemarks.getText().toString());
				

				long rows = db.insert(Database.ACCOUNTS_TABLE_NAME, null, values);
				db.close();
				if ( rows > 0)  {
				    Toast.makeText(this, "Added Account Successfully!",	Toast.LENGTH_LONG).show();
				    this.finish();
				}
				else
					Toast.makeText(this, "Sorry! Could not add account!",	Toast.LENGTH_LONG).show();
				
			} catch (Exception ex) {
				Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
			}
			
		    }
		    else
		    	return;

		  
	  }


	private boolean CheckValidations() {
		// TODO Auto-generated method stub
		
		
		if(editAcno.getText().toString().length()==0){
			editAcno.setError("Account No. is required");
			return false;
			}
		if(editCno.getText().toString().length()==0){
			editCno.setError("Customer No. is required");
			return false;
		}
		if(editHolders.getText().toString().length()==0){
			editHolders.setError("Holder Name is required");
			return false;
		}
		if(editBankName.getText().toString().length()==0){
			editBankName.setError("Bank Name is required");
			return false;
		}
		if(editBranchName.getText().toString().length()==0){
			editBranchName.setError("Branch Name is required");
			return false;
		}
		if(editAddress.getText().toString().length()==0){
			editAddress.setError("Address is required");
			return false;
		}
		if(editIFSC.getText().toString().length()==0){
			editIFSC.setError("IFSC is required");		
			return false;
		}
		if(editMICR.getText().toString().length()==0){
			editMICR.setError("MICR is required");
			return false;
		}
		if(editBalance.getText().toString().length()==0){
			editBalance.setError("Balance is required");
			return false;
		}
		
		
		return true;
	}

}
