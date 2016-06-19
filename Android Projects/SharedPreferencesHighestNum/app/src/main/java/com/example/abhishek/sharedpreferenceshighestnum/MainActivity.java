package com.example.abhishek.sharedpreferenceshighestnum;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
     static String HIGH_SCORE="high_score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SharedPreferences pref=getPreferences(MODE_PRIVATE);

        final TextView highScore=(TextView)findViewById(R.id.high_score);
        highScore.setText(String.valueOf(pref.getInt(HIGH_SCORE,0)));

        final TextView gameScore=(TextView)findViewById(R.id.game_score);
        gameScore.setText(String.valueOf(0));

        Button playButton=(Button)findViewById(R.id.play_button);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r=new Random();
                int val=r.nextInt(1000);
                gameScore.setText(String.valueOf(val));

                if(val > (pref.getInt(HIGH_SCORE,0)))
                {
                    SharedPreferences.Editor editor=pref.edit();
                    editor.putInt(HIGH_SCORE,val);
                    editor.commit();
                    highScore.setText(String.valueOf(val));

                }
            }
        });


        Button reset=(Button)findViewById(R.id.reset_button);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
