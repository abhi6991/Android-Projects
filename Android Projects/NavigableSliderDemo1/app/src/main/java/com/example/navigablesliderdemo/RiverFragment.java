package com.example.navigablesliderdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RiverFragment extends Fragment{
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
int position=getArguments().getInt("position");
String alphabet[]=getResources().getStringArray(R.array.river);
View v=inflater.inflate(R.layout.fragment_layout,container	,false);
TextView tv=(TextView)v.findViewById(R.id.tv_content);
tv.setText(alphabet[position]);
getActivity().getActionBar().setTitle(alphabet[position]);
return v;

}
}
