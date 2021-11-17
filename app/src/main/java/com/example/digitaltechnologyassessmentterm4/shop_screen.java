package com.example.digitaltechnologyassessmentterm4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class shop_screen extends AppCompatActivity {
    MediaPlayer mp; //media player = mp
    MediaPlayer mp2; //media player = mp2

    @Override
    protected void onCreate(Bundle savedInstanceState) { //when created
        super.onCreate(savedInstanceState); //when created load last instance
        setContentView(R.layout.shop_screen); //set the layout to shop_screen.xml
        mp = MediaPlayer.create(shop_screen.this, R.raw.alertnotification);//mp = media player, create
        //shop_screen.this raw alert notification - sets what the variable is for mp2 (alert notification)
        mp2 = MediaPlayer.create(shop_screen.this, R.raw.windthroughtreessfx);//mp = media player, create
        //shop_screen.this raw wind through trees - sets what the variable is for mp2 (windthroughtreessfx)
        mp2.start(); // start mp2 (windthroughtreessfx)
    }

    public void playStore1(View view) { //new void playstore
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=VibeBeatz")); //create new intent to go to the VibeBeatz store
        startActivity(intent); //start the new intent
    }

    public void playStore2(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=VibeBeatz")); //create new intent to go to the VibeBeatz store
        startActivity(intent); //start the new intent
    }

    public void back2main(View view) {
        Intent intent = new Intent(this, main_menu_screen.class); //cfeate new intent to go from shop_screen to main_menu_screen
        mp.start(); // mp start (play alert notification)
        startActivity(intent); //start the new intent
    }
}