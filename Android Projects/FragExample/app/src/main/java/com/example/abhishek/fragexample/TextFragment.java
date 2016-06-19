package com.example.abhishek.fragexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ABHISHEK on 5/29/2016.
 */
public class TextFragment {

    TextView text,vers;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.text_fragment, container, false);
        text= (TextView) view.findViewById(R.id.AndroidOs);
        vers= (TextView)view.findViewById(R.id.Version);


        return view;

    }

    public void change(String txt, String txt1){
        text.setText(txt);
        vers.setText(txt1);

    }
}
