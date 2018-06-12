package com.example.hp.propersleep;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
MediaPlayer mediaPlayer ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            final Button soundStoper = (Button) findViewById(R.id.StopSound);
            soundStoper.animate().alpha(0).setDuration(200);
            final TextView mnumber = (TextView) findViewById(R.id.mnumber);
            final TextView result = (TextView) findViewById(R.id.Done);

            new CountDownTimer(900000, 1000) {
                public void onTick(long millisecondsUntilDone) {
                    mnumber.setText("Time: " + String.valueOf((millisecondsUntilDone / 1000)) + " seconds");
                }

                public void onFinish() {
                    result.setText("wake up  !!!!");
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.cartoon);
                    mediaPlayer.start();
                    soundStoper.animate().alpha(1);
                }
            }.start();
        }


public void stopSound(View view){
    mediaPlayer.stop();

}

}
