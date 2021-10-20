package com.example.digitaltechnologyassessmentterm4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class settings_screen extends AppCompatActivity {
    int minteger = 70;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_screen);
    }

    public void increaseVol(View view) {
        minteger = minteger + 5;
        display(minteger);
    }

    public void decreaseVol(View view) {
        minteger = minteger - 5;
        display(minteger);
    }
    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.sfxvolume);
        displayInteger.setText("" + number);
    }
}