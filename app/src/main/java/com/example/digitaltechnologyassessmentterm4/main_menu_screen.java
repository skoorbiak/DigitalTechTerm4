package com.example.digitaltechnologyassessmentterm4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class main_menu_screen extends AppCompatActivity {
    MediaPlayer mp; //Media player, mp
    MediaPlayer mp2; //Media player, mp2

    @Override
    protected void onCreate(Bundle savedInstanceState) { //when created
        super.onCreate(savedInstanceState); //load the last instance when created
        setContentView(R.layout.main_menu_screen); //set the content to the layout main_menu_screen.xml
        mp = MediaPlayer.create(main_menu_screen.this, R.raw.alertnotification); //mp = media player, create
        //main_menu.this raw alert notification - sets what the variable is for mp2
        mp2 = MediaPlayer.create(main_menu_screen.this, R.raw.windthroughtreessfx); // mp = media player, create
        //main_menu.this raw wind through trees noise - sets what the variable is for mp2
        mp2.start(); //start the music windthroughtreessfx

    }

    public void PlayScreen(View view) { //new void playscreen
        Intent intent = new Intent(this, play_screen.class); //create new intent to go from main_menu screen to play screen
        mp.start(); //play mp (alert notification)
        startActivity(intent); //go to play_screen
    }

    public void CustomiseScreen(View view) { //new void customisescreen
        Intent intent = new Intent(this, customise_screen.class); //create new intent to go from main_menu screen to customise screen
        mp.start(); //start mp (alert notification)
        startActivity(intent); //go to customise_screen
    }

    public void SettingsScreen(View view) { //new void settingsscreen
        Intent intent = new Intent(this, settings_screen.class); //create new intent to go from main_menu screen to settings screen
        mp.start(); //start mp (alert notification)
        startActivity(intent); //go to settings_screen
    }

    public void ShopScreen(View view) { //new void shopscreen
        Intent intent = new Intent(this, shop_screen.class); //create new intent to go from main_menu screen to shop screen
        mp.start(); //start mp (alert notification)
        startActivity(intent); //go to shop_screen
    }
}