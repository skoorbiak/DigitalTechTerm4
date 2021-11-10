package com.example.digitaltechnologyassessmentterm4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class main_menu_screen extends AppCompatActivity {
    MediaPlayer mp;
    MediaPlayer mp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_screen);
        mp = MediaPlayer.create(main_menu_screen.this, R.raw.alertnotification);
        mp2 = MediaPlayer.create(main_menu_screen.this, R.raw.windthroughtreessfx);
        mp2.start();

    }
    public void PlayScreen(View view){
        Intent intent = new Intent(this,play_screen.class);
        mp.start();
        startActivity(intent);
}
    public void CustomiseScreen(View view){
        Intent intent = new Intent(this,customise_screen.class);
        mp.start();
        startActivity(intent);
    }
    public void SettingsScreen(View view){
        Intent intent = new Intent(this,settings_screen.class);
        mp.start();
        startActivity(intent);
    }
    public void ShopScreen(View view){
        Intent intent = new Intent(this,shop_screen.class);
        mp.start();
        startActivity(intent);
    }
}