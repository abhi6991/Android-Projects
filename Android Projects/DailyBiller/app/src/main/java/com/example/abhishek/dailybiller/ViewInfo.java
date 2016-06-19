package com.example.abhishek.dailybiller;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by ABHISHEK on 6/6/2016.
 */
public class ViewInfo extends Activity {

    DataBaseDemo d;
    CustomList c;
    ListView lv;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.view);
            lv=(ListView)findViewById(R.id.listView1);
            refresh();
            registerForContextMenu(lv);

        }


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Delete");
        menu.add(0, v.getId(), 0, "DeleteAll");
    }


    private void refresh(){
        d=new DataBaseDemo(getApplicationContext());
        d.open();
        c=new CustomList(this,d.getRecords());
        lv.setAdapter(c);
        d.close();
    }

    public boolean onContextItemSelected(MenuItem item){
        //Log.e("23243434", "1");
        AdapterView.AdapterContextMenuInfo in=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        int position=in.position;



        if(item.getTitle()=="Delete"){
            d.open();

            //get the object to be deleted
            if(d.delete(d.getRecords().get(position))>0){
                Toast.makeText(getApplicationContext(),"Deleted Successfully", 1000).show();

                refresh();

            }

        }


        if(item.getTitle()=="DeleteAll"){
            d.open();

            if( d.deleteAll())
            {
                Toast.makeText(getApplicationContext(), "Deleted All successfully", 1000).show();

                refresh();
            }

            d.close();
            return true;
        }

        return true;
    }


}
