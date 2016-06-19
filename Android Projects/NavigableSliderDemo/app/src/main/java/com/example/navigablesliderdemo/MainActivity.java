package com.example.navigablesliderdemo;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
DrawerLayout mDrawerlayout;
ListView mListview;
String title="";
ActionBarDrawerToggle mDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title=(String)getTitle();
        mListview=(ListView)findViewById(R.id.drawer_list);
    mDrawerlayout=(DrawerLayout)findViewById(R.id.drawer_layout);
    mDrawerToggle=new ActionBarDrawerToggle(this,mDrawerlayout, R.drawable.ic_launcher, R.string.open, R.string.close){
    	
    @Override
    public void onDrawerClosed(View drawerView) {
    getActionBar().setTitle(title);
    invalidateOptionsMenu();
    }
    
    @Override
    public void onDrawerOpened(View drawerView) {
    getActionBar().setTitle("Select An alphabet");
    invalidateOptionsMenu();
    }
    };
   mDrawerlayout.setDrawerListener(mDrawerToggle);
   
   ArrayAdapter<String> a=new ArrayAdapter<String>(getBaseContext(),R.layout.drawel_list_item,getResources().getStringArray(R.array.river) );
   mListview.setAdapter(a);
   
  getActionBar().setHomeButtonEnabled(true);
   getActionBar().setDisplayHomeAsUpEnabled(true);
   
   mListview.setOnItemClickListener(new OnItemClickListener() {

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		String alphabets[]=getResources().getStringArray(R.array.river);
	     title=alphabets[position];
	     RiverFragment rf=new RiverFragment();
	     Bundle b=new Bundle();
	     b.putInt("position",position);
	     rf.setArguments(b);
	     
	  FragmentManager fm=getFragmentManager();
	  FragmentTransaction ft=fm.beginTransaction();
	   ft.replace(R.id.content_frame,rf);
	   ft.commit();
	     
	   mDrawerlayout.closeDrawer(mListview);
	} 
   });
    }

    @Override
    	protected void onPostCreate(Bundle savedInstanceState) {
    	super.onPostCreate(savedInstanceState);
    	mDrawerToggle.syncState();
    	
    	}
    
    @Override
    	public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater m=getMenuInflater();
    	m.inflate(R.menu.main, menu);
    		return true;
    	}

    @Override
    	public boolean onOptionsItemSelected(MenuItem item) {
    	if(mDrawerToggle.onOptionsItemSelected(item)){
    		return true;
    	}
    		return super.onOptionsItemSelected(item);
    	}
    
   
}
