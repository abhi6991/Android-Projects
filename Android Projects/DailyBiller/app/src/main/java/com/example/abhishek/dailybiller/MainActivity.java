package com.example.abhishek.dailybiller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Intent in;
        switch(item.getItemId())
        {
            case R.id.AddInfo:
             Intent in=new Intent(this,Add.class);
                            startActivity(in);
                            break;
            case R.id.ViewInfo:
                       Intent in1=new Intent(this,ViewInfo.class);
                            startActivity(in1);
                            break;
            case R.id.find:
                Intent in2=new Intent(this,Find.class);
                startActivity(in2);
                break;

        }
        return true;
    }

}
