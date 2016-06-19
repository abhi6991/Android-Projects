package com.example.demo;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Customlist extends ArrayAdapter{

	Activity context;
	List<User> list;
	TextView tv2;
	User u;
	static int position;
	
	public Customlist(Activity context,List<User> list) {
		super(context, R.layout.item, list.toArray());
		this.context=context;
		this.list=list;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater lf=context.getLayoutInflater();
		View v=lf.inflate(R.layout.item,null,false);
		TextView tv1=(TextView)v.findViewById(R.id.ie1);
		TextView tv2=(TextView)v.findViewById(R.id.ie2);
		TextView tv3=(TextView)v.findViewById(R.id.ie3);
		TextView tv4=(TextView)v.findViewById(R.id.ie4);
		Customlist.position=position;
		User u=list.get(position);
		
		tv1.setText("name :"+u.getName());
		tv2.setText("email :"+u.getEmail());
		tv3.setText("ph  :"+u.getPhone());
		tv4.setText("pass  :"+u.getPass());
		return v;
	}
	public String e()
	{
		return u.getEmail();
	}

}
