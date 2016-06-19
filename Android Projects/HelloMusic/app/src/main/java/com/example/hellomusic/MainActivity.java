package com.example.hellomusic;

import java.util.ArrayList;

import android.R.string;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
String externalStoragePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       listSongs=new ArrayList<Song>();
        ListView lv=(ListView)findViewById(R.id.listView1);
        lv.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,listSongs));
        getSongList();

        lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				ContentResolver contentResolver=getContentResolver();
                musicUri=android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                Cursor musicCursor=contentResolver.query(musicUri,null,null,null,null);
               int  music_column_index = musicCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);

                musicCursor.moveToPosition(arg2);
                String filename = musicCursor.getString(music_column_index);
                Intent intent=new Intent(MainActivity.this,MusicActivity.class);
                intent.putExtra("song_name",filename);
      
				intent.putExtra("list",listSongs);
				intent.putExtra("index", arg2);
				startActivity(intent);
			}
        });
       
    }

    ArrayList<Song> listSongs;
    Uri musicUri;
    public  void getSongList(){
        ContentResolver contentResolver=getContentResolver();
         musicUri=android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor musicCursor=contentResolver.query(musicUri,null,null,null,null);
        
        if(musicCursor!=null&& musicCursor.moveToFirst()){
            int titleColumn=musicCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int idColumn=musicCursor.getColumnIndex(MediaStore.Audio.Media._ID);
            int artistColumn=musicCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            do {
                long thisId = musicCursor.getLong(idColumn);
                String thisTitle = musicCursor.getString(titleColumn);
                String thisArtist = musicCursor.getString(artistColumn);
                listSongs.add(new Song(thisId, thisTitle, thisArtist));
            }
            while (musicCursor.moveToNext());
        }
    }

}
