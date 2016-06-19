package com.example.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Record extends Activity{
	Database db;
	Customlist c;
	ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.record);
		lv=(ListView)findViewById(R.id.listView1);
		refresh();
		
		registerForContextMenu(lv); 
		//db.close();
		
		

	}
	
 private void refresh(){
	 db=new Database(getApplicationContext());
		db.open();
		 c=new Customlist(this,db.getRecord());
		lv.setAdapter(c);
//	 Toast.makeText(this,"abhi"+db.getRecord().toString(),Toast.LENGTH_LONG).show();
		db.close();
 }
	
	 @Override   
	    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)  
	    {  
	            super.onCreateContextMenu(menu, v, menuInfo);  
	            menu.setHeaderTitle("Select The Action");    
	            menu.add(0, v.getId(), 0, "Delete");   
	            menu.add(0, v.getId(), 0, "DeleteAll");   
	    }   
	    @Override    
	    public boolean onContextItemSelected(MenuItem item){ 
	    	//Log.e("23243434", "1");
	    	AdapterView.AdapterContextMenuInfo in=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
	    	db=new Database(getApplicationContext());
	        int position=in.position;
	    	
	    	

	    	if(item.getTitle()=="Delete"){
	    		db.open();
	    		if(db.delete(db.getRecord().get(position))>0){
	    		Toast.makeText(getApplicationContext(),"Delete Successfully", 1000).show();
	    	 
	    		refresh();
	    		/*  c.notifyDataSetChanged();
	    		lv.invalidateViews();
	    		lv.refreshDrawableState();*/
	    		}
	    	
	    	}
	    	
	    	if(item.getTitle()=="DeleteAll"){
	            	db.open();
	                
	                 if( db.deleteAll())
	                 {
	                 Toast.makeText(getApplicationContext(), "delete successfully", 1000).show();
	           
	                 }
	                 
	                 db.close();
	                 return true; 
	                 } 
	               
	          return true;    
	      } 
	    

}
