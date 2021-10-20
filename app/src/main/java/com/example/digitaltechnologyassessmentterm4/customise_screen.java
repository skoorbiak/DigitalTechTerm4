package com.example.digitaltechnologyassessmentterm4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class customise_screen extends AppCompatActivity {
    MediaPlayer mp;
    MediaPlayer mp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customise_screen);
        mp = MediaPlayer.create(customise_screen.this, R.raw.alertnotification);
        mp2 = MediaPlayer.create(customise_screen.this, R.raw.windthroughtreessfx);
        mp2.start();
    }
    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }
    public void back2playscreenbtn(View view) {
        Intent intent = new Intent(this,main_menu_screen.class);
        mp.start();
        startActivity(intent);
    }

    public void redtoast(View view) {
        toastMsg("Sorry lad, this feature is coming soon.");
    }

    public void bluetoast(View view) {
        toastMsg("Sorry lad, this feature is coming soon.");
    }

    public void greentoast(View view) {
        toastMsg("Sorry lad, this feature is coming soon.");
    }

    public void yellowtoast(View view) {
        toastMsg("Sorry lad, this feature is coming soon.");
    }

    public void backgroundtoast(View view) {
        toastMsg("Sorry lad, this feature is coming soon.");
    }
}