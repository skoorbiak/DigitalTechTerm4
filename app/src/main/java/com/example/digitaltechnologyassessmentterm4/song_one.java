package com.example.digitaltechnologyassessmentterm4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class song_one extends AppCompatActivity {
    Timer timer;
    Timer timer2;
    MediaPlayer mp;
    MediaPlayer mp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_one);
        mp = MediaPlayer.create(song_one.this, R.raw.alertnotification);
        mp2 = MediaPlayer.create(song_one.this, R.raw.sparkoflightsong);
        timer = new Timer();
        timer2 = new Timer();
        timer2.schedule(new TimerTask(){
            @Override
            public void run() {
                mp2.start();
            }
        }, 3000);
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
            Intent intent = new Intent (song_one.this, win_screen.class);
            startActivity(intent);
            mp.start();
            }
        }, 165000);
    }
}