package com.example.abhishek.dailybiller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;

/**
 * Created by ABHISHEK on 6/7/2016.
 */
public class Find extends Activity {

    DataBaseDemo db;
    AutoCompleteTextView ac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find);

        ac= (AutoCompleteTextView) findViewById(R.id.ac);
        db=new DataBaseDemo(getApplicationContext());
        db.open();
        ac.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,db.getRecords()));
        ac.setThreshold(1);
        db.close();



        ac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                db.open();
                DayDetails day=db.getByDate(ac.getText().toString());
                Intent in=new Intent(getApplicationContext(),FindLayout.class);
                in.putExtra("day", (Serializable) day);
                startActivity(in);
                db.close();
            }
        });

    }
}
