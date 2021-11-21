package com.example.digitaltechnologyassessmentterm4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class customise_screen extends AppCompatActivity {
    MediaPlayer mp; //Media player, mp
    MediaPlayer mp2; //Media player, mp2
    @Override
    protected void onCreate(Bundle savedInstanceState) { //when created
        super.onCreate(savedInstanceState); //when created load last saved instance
        setContentView(R.layout.customise_screen); //set the content of the screen to customise_screen.xml
        mp = MediaPlayer.create(customise_screen.this, R.raw.alertnotification);//mp = media player, create
        //customise_menu.this raw alert notification - sets what the variable is for mp2
        mp2 = MediaPlayer.create(customise_screen.this, R.raw.windthroughtreessfx);//mp = media player, create
        //customise_menu.this raw alert notification - sets what the variable is for mp2
        mp2.start(); //start mp2 (windthroughtrees)
    }
    public void toastMsg(String msg) { //new void toastmsg
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG); //create a new toast and make the length long
        toast.show(); //show the toast
    }
    public void back2playscreenbtn(View view) { //new void back2play screen
        Intent intent = new Intent(this,main_menu_screen.class); //create new activity to go from customise screen to main_menu screen
        mp.start(); //start mp (notification)
        startActivity(intent); //go to next activity
    }

    public void redtoast(View view) {
        toastMsg("Sorry lad, this feature is coming soon.");
    } // create new toast and make it say "this feature is coming soon"

    public void bluetoast(View view) {
        toastMsg("Sorry lad, this feature is coming soon.");
    } // create new toast and make it say "this feature is coming soon"

    public void greentoast(View view) {
        toastMsg("Sorry lad, this feature is coming soon.");
    } // create new toast and make it say "this feature is coming soon"

    public void yellowtoast(View view) {
        toastMsg("Sorry lad, this feature is coming soon.");
    } // create new toast and make it say "this feature is coming soon"

    public void backgroundtoast(View view) {
        toastMsg("Sorry lad, this feature is coming soon.");
    } // create new toast and make it say "this feature is coming soon"
}