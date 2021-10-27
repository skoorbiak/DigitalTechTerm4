package com.example.digitaltechnologyassessmentterm4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class shop_screen extends AppCompatActivity {
    MediaPlayer mp;
    MediaPlayer mp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_screen);
        mp = MediaPlayer.create(shop_screen.this, R.raw.alertnotification);
        mp2 = MediaPlayer.create(shop_screen.this, R.raw.windthroughtreessfx);
        mp2.start();
    }

    public void playStore1(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=VibeBeatz")); /// here "yourpackegName" from your app packeg Name
        startActivity(intent);
    }

    public void playStore2(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=VibeBeatz")); /// here "yourpackegName" from your app packeg Name
        startActivity(intent);
    }
    public void back2main(View view){
        Intent intent = new Intent(this,main_menu_screen.class);
        mp.start();
        startActivity(intent);
    }
}