package com.example.abhishek.dailybiller;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by ABHISHEK on 6/9/2016.
 */
public class FindLayout  extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findlayout);

        TextView t1= (TextView) findViewById(R.id.ft1);
        TextView t2= (TextView) findViewById(R.id.ft2);
        TextView t3= (TextView) findViewById(R.id.ft3);
        TextView t4= (TextView) findViewById(R.id.ft4);
        TextView t5= (TextView) findViewById(R.id.ft5);

        Bundle b=getIntent().getExtras();
        DayDetails d= (DayDetails) b.getSerializable("day");

        if(d!=null)
        {
            t1.setText("Date: " + d.getDate());
            t2.setText("Item Name: " + d.getName());
            t3.setText("Price: " + d.getPrice());
            t4.setText("No of items: " + d.getNo());
            t5.setText("Amount: " + d.getAmount());
        }
    }
}
