package com.example.digitaltechnologyassessmentterm4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class settings_screen extends AppCompatActivity {
    int minteger = 70; //integer minteger is 70.
    MediaPlayer mp; //media player = mp
    MediaPlayer mp2; //media player = mp2

    @Override
    protected void onCreate(Bundle savedInstanceState) {//when created
        super.onCreate(savedInstanceState); //when created load the last saved instance
        setContentView(R.layout.settings_screen); //set the content of the layout to settings_screen.xml
        mp = MediaPlayer.create(settings_screen.this, R.raw.alertnotification);//mp = media player, create
        //play_screen.this raw alert notification - sets what the variable is for mp2 (alert notification)
        mp2 = MediaPlayer.create(settings_screen.this, R.raw.windthroughtreessfx);//mp = media player, create
        //play_screen.this raw wind through trees - sets what the variable is for mp2 (windthroughtreessfx)
        mp2.start(); //start the song wind through trees sfx
    }

    public void increaseVolSFX(View view) { //new void increase the volume of sfx
        minteger = minteger + 5; //adds 5 to the minteger(70)
        mp.start(); //start alert notification sound
        display(minteger); //display the new integer
    }

    public void decreaseVolSFX(View view) { //new void decrease the volume of sfx
        minteger = minteger - 5; //takes 5 from the minteger(70)
        mp.start(); //start alert notification sound
        display(minteger); //display the new integer
    }

    public void display(int number) { //new void, display the integer number
        TextView displayInteger = (TextView) findViewById(
                R.id.sfxvolume); //find the textview sfxvolume
        displayInteger.setText("" + number); //display the integer and set the text to "" + number
    }

    public void display2(int number2) { //new void, display2 the integer number
        TextView displayInteger = (TextView) findViewById(
                R.id.volume_text_view); //find the textview volume_text_view
        displayInteger.setText("" + number2); //display the integer and set the text to "" + number
    }

    public void increaseVol(View view) {
        minteger = minteger + 5; //adds 5 to the minteger(70)
        mp.start(); //start mp (alert notifcation
        display2(minteger); //display the new minteger
    }

    public void decreaseVol(View view) {
        minteger = minteger - 5; //takes 5 from the minteger(70)
        mp.start(); //start mp (alert notifcation
        display2(minteger); //display the new minteger
    }

    public void back2mainscreen_btn(View view) {
        Intent intent = new Intent(this, main_menu_screen.class); //create new intent to go from settings_screen to main_screen
        mp.start(); //start mp (alert notifcation
        startActivity(intent); //start the new intent
    }
}