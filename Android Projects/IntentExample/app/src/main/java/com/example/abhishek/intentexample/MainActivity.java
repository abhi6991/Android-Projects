package com.example.abhishek.intentexample;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("tagg","Conf changed");
    }

    public void process(View v)
    {
        Intent intent=null,chooser=null;
        if(v.getId()==R.id.launch_market)
        {
            intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:19.076,72.877"));
            chooser=intent.createChooser(intent,"launch map");
            startActivity(chooser);
        }

        if(v.getId()==R.id.launch_map)
        {
            intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=dolphin.developers.com"));
            chooser=intent.createChooser(intent,"launch market");
            startActivity(chooser);

        }
        if(v.getId()==R.id.send_email)
        {
            intent=new Intent(intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String to[]={"vaibhav998819@gmail.com","sonasharma20594@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL,to);
            intent.putExtra(Intent.EXTRA_SUBJECT,"sent from mobile");
            intent.putExtra(Intent.EXTRA_TEXT,"this was sent from app");
            intent.setType("message/rfc822");
            chooser=Intent.createChooser(intent,"Email senders");
            startActivity(chooser);
        }
        if(v.getId()==R.id.send_image)
        {
            intent=new Intent(intent.ACTION_SEND);
            Uri imageUri=Uri.parse("android.resource://com.example.abhishek.intentexample/mipmap/"+R.mipmap.ic_launcher);
            intent.setType("image/*");
            intent.putExtra(intent.EXTRA_STREAM,imageUri);
            intent.putExtra(intent.EXTRA_TEXT,"Hey this image was attached by me");
            chooser=Intent.createChooser(intent,"Image Senders");
            startActivity(intent);

        }

        if(v.getId()==R.id.send_images)
        {
            File pictures= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            String listOfPictures[]=pictures.list();
            for(String picture:listOfPictures)
            {
                Toast.makeText(this,picture,Toast.LENGTH_LONG).show();
            }
        }

    }
}
