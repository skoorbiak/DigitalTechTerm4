package com.example.digitaltechnologyassessmentterm4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class play_screen extends AppCompatActivity {
    MediaPlayer mp; //Media player, mp
    MediaPlayer mp2; //Media player, mp2
    MediaPlayer mp3; //Media player, mp3

    @Override
    protected void onCreate(Bundle savedInstanceState) { //when created
        super.onCreate(savedInstanceState); //when created load the last saved instance
        setContentView(R.layout.play_screen); //set the content play_screen.xml
        mp = MediaPlayer.create(play_screen.this, R.raw.alertnotification); //mp = media player, create
        //play_screen.this raw alert notification - sets what the variable is for mp2 (alert notification)
        mp2 = MediaPlayer.create(play_screen.this, R.raw.windthroughtreessfx);//mp = media player, create
        //play_screen.this raw wind through trees - sets what the variable is for mp2 (windthroughtreessfx)
        mp2.stop(); //stop mp2
    }

    public void go2songone(View view) { //new void to go to song one
        Intent intent = new Intent(this, song_one.class);
        if (mp != null && mp2.isPlaying()) { //if mp is not null, and mp2 is playing
            mp2.stop(); //stop mp2
            mp2.release(); //release mp2
            mp2 = null; //make mp2 null
        }
        mp3 = MediaPlayer.create(this, R.raw.sparkoflightsong); //mp = media player, create
        //play_screen.this raw spark of light - sets what the variable is for mp2 (sparkoflightsong)
        mp3.start(); //start mp (spark of light song)
        startActivity(intent); //start the activity
    }

    public void backtomain(View view) { //new void back to main_menu screen
        Intent intent = new Intent(this, main_menu_screen.class);  //create new intent to go from play_screen to main_screen
        mp.start(); //start mp (alert notification)
        startActivity(intent); //start the new intent
    }
}