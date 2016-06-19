package com.example.abhishek.spinnerexample;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {


    private ImageView image;
    private String[] states;
    private Spinner spinner;
    private TypedArray imgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        states = getResources().getStringArray(R.array.countries_list);
        imgs = getResources().obtainTypedArray(R.array.countries_flag_list);

        image = (ImageView) findViewById(R.id.country_image);
        spinner = (Spinner) findViewById(R.id.country_spinner);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, states);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                image.setImageResource(imgs.getResourceId(
                        spinner.getSelectedItemPosition(), -1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }
}
