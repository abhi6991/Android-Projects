package com.example.abhishek.baseadapterexample;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         list=(ListView)findViewById(R.id.listView);
    }
}

class SingleRow{
    String title;
    String description;
    int img;
        SingleRow(String title,String description,int img){
            this.title=title;
            this.description=description;
            this.img=img;

        }

}
class AbhiAdapter extends BaseAdapter{

    ArrayList<SingleRow> list;
    Context context;
    AbhiAdapter(Context c) {
        context=c;
        list = new ArrayList<SingleRow>();
        Resources res = c.getResources();
        String titles[] = res.getStringArray(R.array.titles);
        String description[] = res.getStringArray(R.array.description);
        int images[] = {R.drawable.meme1, R.drawable.meme2, R.drawable.meme3, R.drawable.meme4, R.drawable.meme5, R.drawable.meme6, R.drawable.meme7, R.drawable.meme8, R.drawable.meme9, R.drawable.meme10}
        for (int i = 0; i < 10; i++) {
            list.add(new SingleRow(titles[i],description[i],images[i]));

        }
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.id.single_row,parent,null);



    }
}