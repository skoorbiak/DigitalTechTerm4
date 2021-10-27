package com.example.digitaltechnologyassessmentterm4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class settings_screen extends AppCompatActivity {
    int minteger = 70;
    MediaPlayer mp;
    MediaPlayer mp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_screen);
        mp = MediaPlayer.create(settings_screen.this, R.raw.alertnotification);
        mp2 = MediaPlayer.create(settings_screen.this, R.raw.windthroughtreessfx);
        mp2.start();
    }

    public void increaseVolSFX(View view) {
        minteger = minteger + 5;
        mp.start();
        display(minteger);
    }

    public void decreaseVolSFX(View view) {
        minteger = minteger - 5;
        mp.start();
        display(minteger);
    }
    public void display(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.sfxvolume);
        displayInteger.setText("" + number);
    }
    public void display2(int number2) {
        TextView displayInteger = (TextView) findViewById(
                R.id.volume_text_view);
        displayInteger.setText("" + number2);
    }
    public void increaseVol(View view) {
        minteger = minteger + 5;
        mp.start();
        display2(minteger);
    }
    public void decreaseVol(View view){
        minteger = minteger - 5;
        mp.start();
        display2(minteger);
    }

    public void back2mainscreen_btn(View view) {
        Intent intent = new Intent(this,main_menu_screen.class);
        mp.start();
        startActivity(intent);
    }
}