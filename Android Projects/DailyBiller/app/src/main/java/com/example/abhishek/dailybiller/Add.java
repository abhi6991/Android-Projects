package com.example.abhishek.dailybiller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ABHISHEK on 6/6/2016.
 */
public class Add extends Activity {
   EditText date,name,price,amnt,no;
    Button save,clear,tamount;
    float pri,am;
    int n;
    Pattern pattern;
    Matcher matcher;
    private final String DATE="[0-9][0-9]/[0-9][0-9]/[0-9][0-9]";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        date=(EditText)findViewById(R.id.addate);
        name=(EditText)findViewById(R.id.adname);
        price=(EditText)findViewById(R.id.adprice);
        no=(EditText)findViewById(R.id.adno);
        amnt=(EditText)findViewById(R.id.adamount);
        tamount=(Button)findViewById(R.id.adtotal);
        save=(Button)findViewById(R.id.adsave);
        clear=(Button)findViewById(R.id.adclear);


        tamount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    pri=Float.parseFloat(price.getText().toString());
                    n=Integer.parseInt(no.getText().toString());
                    am=pri*n;
                    amnt.setText(am+"");
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    DataBaseDemo d=new DataBaseDemo(getApplicationContext());
                    d.open();
                    DayDetails day=new DayDetails();
                        day.setDate(date.getText().toString());
                        day.setName(name.getText().toString());
                         day.setName(price.getText().toString());
                            day.setName(no.getText().toString());
                 day.setName(amnt.getText().toString());

                if(valid()) {
                    if (d.insert(day) > 0) {
                        Toast.makeText(getApplicationContext(), "saved successfully", Toast.LENGTH_LONG).show();
                    }
                }
                d.close();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("");
                name.setText("");
                price.setText("");
                no.setText("");
                amnt.setText("");
            }
        });

    }

    public boolean valid()
    {
        if(date.getText().toString().equals("") || !isValid(date.getText().toString()))
        {
            date.setError("please write the correct date");
            date.requestFocus();
            return false;
        }
        if(name.getText().toString().equals(""))
        {
            name.setError("write the name");
            name.requestFocus();
            return false;

        }
        if(price.getText().toString().equals(""))
        {
            price.setError("write the price of item");
            price.requestFocus();
            return false;
        }
        if(no.getText().toString().equals(""))
        {
            no.setError("write no of items");
            no.requestFocus();
            return false;
        }
        if(amnt.getText().toString().equals(""))
        {
            amnt.setError("press the amount button ");
            amnt.requestFocus();
            return false;
        }
        else
            return true;
    }


    public boolean isValid(String dat)
    {
        pattern=Pattern.compile(DATE);
        matcher=pattern.matcher(dat);
        return matcher.matches();

    }
}
