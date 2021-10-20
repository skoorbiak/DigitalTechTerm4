package com.example.digitaltechnologyassessmentterm4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class main_menu_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_screen);
    }
    public void PlayScreen(View view){
        Intent intent = new Intent(this,play_screen.class);
        startActivity(intent);
}
    public void CustomiseScreen(View view){
        Intent intent = new Intent(this,customise_screen.class);
        startActivity(intent);
    }
    public void SettingsScreen(View view){
        Intent intent = new Intent(this,settings_screen.class);
        startActivity(intent);
    }
    public void ShopScreen(View view){
        Intent intent = new Intent(this,shop_screen.class);
        startActivity(intent);
    }
}