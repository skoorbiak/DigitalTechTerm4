package com.example.digitaltechnologyassessmentterm4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class play_screen extends AppCompatActivity {
    MediaPlayer mp;
    MediaPlayer mp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_screen);
        mp = MediaPlayer.create(play_screen.this, R.raw.alertnotification);
        mp2 = MediaPlayer.create(play_screen.this, R.raw.windthroughtreessfx);
        mp2.start();
    }

    public void go2songone(View view) {
        Intent intent = new Intent(this,song_one.class);
        mp.start();
        mp2.stop();
        startActivity(intent);

    }

    public void backtomain(View view) {
        Intent intent = new Intent (this, main_menu_screen.class);
        mp.start();
        startActivity(intent);
    }
}