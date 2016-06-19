package com.example.abhishek.dailybiller;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ABHISHEK on 6/7/2016.
 */
public class CustomList extends ArrayAdapter{
Activity context;
    List<DayDetails> list;
    public CustomList(Activity context, List<DayDetails> list) {
        super(context, R.layout.listitem, list.toArray());
        this.context=context;
        this.list=list;

    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater lf=context.getLayoutInflater();
        View v=lf.inflate(R.layout.listitem,null,false);
        TextView t1=(TextView)v.findViewById(R.id.tdate);
        TextView t2=(TextView)v.findViewById(R.id.tname);
        TextView t3=(TextView)v.findViewById(R.id.tprice);
        TextView t4=(TextView)v.findViewById(R.id.tno);
        TextView t5=(TextView)v.findViewById(R.id.tamount);

        DayDetails day=list.get(position);

        //DayDetails days[]= (DayDetails[]) list.toArray();
        //DayDetails day=days[position];

        t1.setText("Date: "+day.getDate());
        t2.setText("Name: "+day.getName());
        t3.setText("Price: "+day.getPrice()+"");
        t4.setText("No of Days: "+day.getNo());
        t5.setText("Amount: "+day.getAmount()+"");


        return v;

    }
}
