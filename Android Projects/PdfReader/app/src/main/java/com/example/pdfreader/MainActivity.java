package com.example.pdfreader;

import java.io.File;

import com.sun.pdfview.PDFRenderer;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
ImageView imageview;
int currentpage=0;
Button next,previous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    next=(Button)findViewById(R.id.next);
    previous=(Button)findViewById(R.id.pre);
    next.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
		currentpage++;
			render();
		}
	});
    previous.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
		currentpage--;
		render();
			
		}
	});
	render();
    }
	private void render() {
		try{
			imageview=(ImageView)findViewById(R.id.im);
			int width=imageview.getWidth();
			int height=imageview.getHeight();
		    Bitmap bitmap=Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_4444);
		    File f=new File("/sdcard/Download/deep.pdf");
		    PDFRenderer p=new PDFRenderer(ParcelFileDescriptor.open(f, ParcelFileDescriptor.MODE_READ_ONLY));
		    android.graphics.Picture;
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
    
}
