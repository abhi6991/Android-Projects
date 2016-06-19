package com.example.hellomusic;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MusicActivity extends Activity{
	Button p,s,n;
	MediaPlayer mp=new MediaPlayer();
	ArrayList a;
	int index;
	String file;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.music);
		p=(Button)findViewById(R.id.button1);
		s=(Button)findViewById(R.id.button2);
		n=(Button)findViewById(R.id.button3);
		Bundle b=getIntent().getExtras();
		
		a=(ArrayList)b.getSerializable("listsong");
		index=b.getInt("index");
		file=b.getString("song_name");
		try {
			mp.setDataSource(file);
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		p.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
		  try {
			  //mp.stop();
				  mp.prepare();
				  mp.start();

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
				
			
			}
		});

		s.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				mp.stop();
				
			}
		});
		

		n.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				file= (String) a.get(index + 1);

				try {
					mp.setDataSource(file);
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}



				try {
					//mp.stop();
						mp.prepare();
						mp.start();

				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	
	
	}

}
