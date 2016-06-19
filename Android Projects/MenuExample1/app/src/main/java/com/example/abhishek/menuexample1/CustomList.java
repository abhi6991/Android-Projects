package com.example.abhishek.menuexample1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ABHISHEK on 6/6/2016.
 */

public class CustomList extends ArrayAdapter {
    List<User> list;
    Activity context;
    public CustomList(Activity context,List<User> list) {
        super(context,R.layout.listitem,list.toArray());
        this.list=list;
        this.context=context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater l=context.getLayoutInflater();
        View v=l.inflate(R.layout.listitem, null, false);

        TextView t1=(TextView)v.findViewById(R.id.textView1);
        TextView t2=(TextView)v.findViewById(R.id.textView2);
        TextView t3=(TextView)v.findViewById(R.id.textView3);

        //User u=list.get(position);
        Object o[]=list.toArray();
        User u=(User)o[position];


        t1.setText(u.getName());
        t2.setText(u.getEmail());
        t3.setText(u.getPhone());


        return v;

    }

}
