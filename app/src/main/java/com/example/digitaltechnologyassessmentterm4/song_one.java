package com.example.digitaltechnologyassessmentterm4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class song_one extends AppCompatActivity {
    ImageView iv_11, iv_12, iv_13,
            iv_21, iv_22, iv_23,
            iv_31, iv_32, iv_33,
            iv_41, iv_42, iv_43,
            iv_51, iv_52, iv_53; //Give the declaration that iv_ is an image view
    Button buttonply; //Give the declaration that buttonply is a button
    TextView time_remain, number_score, number_best; //Give the declaration that time, number and best are text views
    Random r; //Give the declaration that r is random
    int rockLocationRow1, rockLocationRow2, rockLocationRow3, rockLocationRow4, rockLocationRow5; //new int rock(grid) location
    int tapImage1, tapImage2, tapImage3, tapImage4, blankImage, frameImage; //new int tapImage (tappable imageviews)
    int currentScore = 0; //set the current score to 0
    int bestScore = 0; //set the best score to 0
    CountDownTimer timer3; //new countdown timer, timer3
    MediaPlayer mp2; //new media player, mp2

    @Override
    protected void onCreate(Bundle savedInstanceState) { //when created
        super.onCreate(savedInstanceState); //load last instance
        setContentView(R.layout.song_one); //set the content to song_one
        mp2 = MediaPlayer.create(song_one.this, R.raw.sparkoflightsong);//mp = media player, create
        //song_one.this raw spark of light song - sets what the variable is for mp2 (spark of light song)

        SharedPreferences preferences = getSharedPreferences("PREFS", 0); //create shared preferences to save for later
        bestScore = preferences.getInt("highscore", 0); //create new preference high score

        iv_11 = (ImageView) findViewById(R.id.iv_11); //find image view
        iv_12 = (ImageView) findViewById(R.id.iv_12); //find image view
        iv_13 = (ImageView) findViewById(R.id.iv_13); //find image view

        iv_21 = (ImageView) findViewById(R.id.iv_21); //find image view
        iv_22 = (ImageView) findViewById(R.id.iv_22); //find image view
        iv_23 = (ImageView) findViewById(R.id.iv_23); //find image view

        iv_31 = (ImageView) findViewById(R.id.iv_31); //find image view
        iv_32 = (ImageView) findViewById(R.id.iv_32); //find image view
        iv_33 = (ImageView) findViewById(R.id.iv_33); //find image view

        iv_41 = (ImageView) findViewById(R.id.iv_41); //find image view
        iv_42 = (ImageView) findViewById(R.id.iv_42); //find image view
        iv_43 = (ImageView) findViewById(R.id.iv_43); //find image view

        iv_51 = (ImageView) findViewById(R.id.iv_51); //find image view
        iv_52 = (ImageView) findViewById(R.id.iv_52); //find image view
        iv_53 = (ImageView) findViewById(R.id.iv_53); //find image view

        buttonply = (Button) findViewById(R.id.buttonply);  //find button

        number_score = (TextView) findViewById(R.id.number_score);  //find text view
        number_score.setText("SCORE: " + currentScore); //set score + current score

        number_best = (TextView) findViewById(R.id.number_best); //find text view
        number_best.setText("SCORE: " + bestScore); //set score: + best score

        time_remain = (TextView) findViewById(R.id.time_remain); //find text view
        time_remain.setText("TIME: " + millisToTime(163000)); //set remaining time to Time: + milliseconds left
        r = new Random(); //create new random
        loadImages(); //load all images
        timer3 = new CountDownTimer(163000, 1000) { //new countdown timer
            @Override
            public void onTick(long millisUntilFinished) { //when a millisecond goes by
                time_remain.setText("TIME: " + millisToTime(millisUntilFinished) + 1);
            }


            @Override
            public void onFinish() {
                time_remain.setText("TIME: " + millisToTime(0)); //when finished, time is 0

                iv_31.setEnabled(false); //set iv_31 to false
                iv_32.setEnabled(false); //set iv_32 to false
                iv_33.setEnabled(false); //set iv_33 to false
                buttonply.setVisibility(View.VISIBLE); //set button to visible

                iv_11.setImageResource(blankImage); //set iv to blank image
                iv_12.setImageResource(blankImage); //set iv to blank image
                iv_13.setImageResource(blankImage); //set iv to blank image

                iv_21.setImageResource(blankImage); //set iv to blank image
                iv_22.setImageResource(blankImage); //set iv to blank image
                iv_23.setImageResource(blankImage); //set iv to blank image


                iv_31.setImageResource(blankImage); //set iv to blank image
                iv_32.setImageResource(blankImage); //set iv to blank image
                iv_33.setImageResource(blankImage); //set iv to blank image


                iv_41.setImageResource(blankImage); //set iv to blank image
                iv_42.setImageResource(blankImage); //set iv to blank image
                iv_43.setImageResource(blankImage); //set iv to blank image


                iv_51.setImageResource(blankImage); //set iv to blank image
                iv_52.setImageResource(blankImage); //set iv to blank image
                iv_53.setImageResource(blankImage); //set iv to blank image

                Toast.makeText(song_one.this, "Game Over!", Toast.LENGTH_SHORT).show(); //create new toast "game over"
                if (currentScore > bestScore) { //if the current score is greater than the best score
                    bestScore = currentScore; //make the best score the current score
                    number_best.setText("BEST: " + bestScore); //update the best score text
                    SharedPreferences preferences1 = getSharedPreferences("PREFS", 0); //set this as the shared preference
                    SharedPreferences.Editor editor = preferences1.edit(); //keep the preference
                    editor.putInt("highscore", bestScore); //create this as a "highscore"
                    editor.apply(); //apply this change every time it is run
                }
            }
        };


        iv_31.setOnClickListener(new View.OnClickListener() { //new onclick listener
            @Override
            public void onClick(View v) { //when clicked
                if (rockLocationRow3 == 1) { //if the rock location is 1
                    continueGame(); //continue the game
                } else { //if not
                    endGame(); //end the game
                }
            }
        });
        iv_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //when clicked
                if (rockLocationRow3 == 2) { //if the rock location is 2
                    continueGame();//continue the game
                } else {//if not
                    endGame(); //end the game
                }
            }
        });
        iv_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //when clicked
                if (rockLocationRow3 == 3) { //if the rock location is 3
                    continueGame();//continue the game
                } else {//if not
                    endGame(); //end the game
                }
            }
        });

        buttonply.setOnClickListener(new View.OnClickListener() { //when clicked
            @Override
            public void onClick(View v) {
                initGame();
            } //start game
        });


    }

    public void continueGame() {
        //row4
        rockLocationRow4 = rockLocationRow3;
        setRockLocation(rockLocationRow4, 4); //set the buttonply location to row 4

        //row3
        rockLocationRow3 = rockLocationRow2;
        setRockLocation(rockLocationRow3, 3); //set the buttonply location to row 3

        //row2
        rockLocationRow2 = rockLocationRow1;
        setRockLocation(rockLocationRow2, 2); //set the buttonply location to row 2

        //row1
        rockLocationRow1 = r.nextInt(3) + 1; //set the next rock location to random
        setRockLocation(rockLocationRow1, 1); //set the buttonply location to row 1

        currentScore++; //add current score +1
        number_score.setText("SCORE: " + currentScore); //set the new current score
    }

    private void loadImages() {
        frameImage = R.drawable.circle_frame_ic; //set the image frame image to circle_frame
        tapImage1 = R.drawable.yellow_circle_ic; //set the image frame image to circle_yellow
        tapImage2 = R.drawable.green_circle_ic; //set the image frame image to circle_green
        tapImage3 = R.drawable.red_circle_ic; //set the image frame image to circle_red
        tapImage4 = R.drawable.blue_circle_ic; //set the image frame image to circle_blue
        blankImage = R.drawable.blankimg; //set the image frame image to circle_blank
    }

    private int millisToTime(long millis) {
        return (int) millis / 1000; //make the milliseconds go down one every tick
    } //private integer millistotime

    private void initGame() { //initiate game
        mp2.start(); //start mp2 (spark of light song)
        iv_31.setEnabled(true); //set iv_31 to true
        iv_32.setEnabled(true); //set iv_32 to true
        iv_33.setEnabled(true); //set iv_33 to true
        iv_11.setImageResource(tapImage1); //set the imageresource to tapimage1
        iv_12.setImageResource(tapImage4); //set the imageresource to tapimage4
        iv_13.setImageResource(tapImage3); //set the imageresource to tapimage3

        iv_21.setImageResource(tapImage1); //set the imageresource to tapimage1
        iv_22.setImageResource(tapImage4); //set the imageresource to tapimage4
        iv_23.setImageResource(tapImage3); //set the imageresource to tapimage3

        iv_31.setImageResource(tapImage1); //set the imageresource to tapimage1
        iv_32.setImageResource(tapImage4); //set the imageresource to tapimage4
        iv_33.setImageResource(tapImage3); //set the imageresource to tapimage3

        iv_41.setImageResource(tapImage1); //set the imageresource to tapimage1
        iv_42.setImageResource(tapImage4); //set the imageresource to tapimage4
        iv_43.setImageResource(tapImage3); //set the imageresource to tapimage3

        iv_51.setImageResource(tapImage1); //set the imageresource to tapimage1
        iv_52.setImageResource(tapImage4); //set the imageresource to tapimage4
        iv_53.setImageResource(tapImage3); //set the imageresource to tapimage3
        buttonply.setVisibility(View.INVISIBLE); //set the buttonply to invisible
        currentScore = 0; //make the current score 0
        number_score.setText("SCORE: " + currentScore); //make the score +
        timer3.start(); //start the timer

        //row5 - nothing
        //row4
        rockLocationRow5 = 2;
        iv_52.setImageResource(frameImage);
        //row5 - nothing
        //row4
        rockLocationRow4 = 2;
        iv_42.setImageResource(frameImage);
        //row5 - nothing
        //row4
        rockLocationRow3 = 2;
        iv_32.setImageResource(frameImage);
        //row5 - nothing
        //row4
        rockLocationRow2 = r.nextInt(3) + 1;
        setRockLocation(rockLocationRow2, 2);

        //row5 - nothing
        //row4
        rockLocationRow1 = r.nextInt(3) + 1;
        setRockLocation(rockLocationRow1, 1);
    }

    private void endGame() { //new private void end game
        timer3.cancel(); //stop the timer
        mp2.stop(); //stop the music
        iv_31.setEnabled(false); //set iv_ to false
        iv_32.setEnabled(false); //set iv_ to false
        iv_33.setEnabled(false); //set iv_ to false
        buttonply.setVisibility(View.VISIBLE);  //set the button to visible

        iv_11.setImageResource(blankImage); //set the imageresource to blankimage
        iv_12.setImageResource(blankImage); //set the imageresource to blankimage
        iv_13.setImageResource(blankImage); //set the imageresource to blankimage

        iv_21.setImageResource(blankImage); //set the imageresource to blankimage
        iv_22.setImageResource(blankImage); //set the imageresource to blankimage
        iv_23.setImageResource(blankImage); //set the imageresource to blankimage

        iv_31.setImageResource(blankImage); //set the imageresource to blankimage
        iv_32.setImageResource(blankImage); //set the imageresource to blankimage
        iv_33.setImageResource(blankImage); //set the imageresource to blankimage

        iv_41.setImageResource(blankImage); //set the imageresource to blankimage
        iv_42.setImageResource(blankImage); //set the imageresource to blankimage
        iv_43.setImageResource(blankImage); //set the imageresource to blankimage

        iv_51.setImageResource(blankImage); //set the imageresource to blankimage
        iv_52.setImageResource(blankImage); //set the imageresource to blankimage
        iv_53.setImageResource(blankImage); //set the imageresource to blankimage

        Toast.makeText(song_one.this, "Failed!", Toast.LENGTH_SHORT).show(); //create new toast "failed"
    }

    private void setRockLocation(int place, int row) {
        if (row == 1)//if the rock location is in row 1//
        {
            iv_11.setImageResource(blankImage);  //set the imageresource to blankimage
            iv_12.setImageResource(blankImage);  //set the imageresource to blankimage
            iv_13.setImageResource(blankImage);  //set the imageresource to blankimage

            switch (place) { //place images
                case 1:
                    iv_11.setImageResource(tapImage1);  //set the imageresource to tapImage3
                    break; //break the image
                case 2:
                    iv_12.setImageResource(tapImage2);  //set the imageresource to tapImage3
                    break; //break the image
                case 3:
                    iv_13.setImageResource(tapImage3);  //set the imageresource to tapImage3
                    break; //break the image
            }
        }
        if (row == 2) {
            iv_21.setImageResource(blankImage); //set the imageresource to blankimage
            iv_22.setImageResource(blankImage); //set the imageresource to blankimage
            iv_23.setImageResource(blankImage); //set the imageresource to blankimage

            switch (place) {
                case 1:
                    iv_21.setImageResource(tapImage1);  //set the imageresource to tapImage1
                    break; //break the image
                case 2:
                    iv_22.setImageResource(tapImage2);  //set the imageresource to tapImage2
                    break; //break the image
                case 3:
                    iv_23.setImageResource(tapImage3);  //set the imageresource to tapImage3
                    break; //break the image
            }
        }
        if (row == 3) {
            iv_31.setImageResource(blankImage); //set the imageresource to blankimage
            iv_32.setImageResource(blankImage); //set the imageresource to blankimage
            iv_33.setImageResource(blankImage); //set the imageresource to blankimage

            switch (place) {
                case 1:
                    iv_31.setImageResource(tapImage1);  //set the imageresource to tapImage1
                    break; //break the image
                case 2:
                    iv_32.setImageResource(tapImage2);  //set the imageresource to tapImage2
                    break; //break the image
                case 3:
                    iv_33.setImageResource(tapImage3);  //set the imageresource to tapImage3
                    break; //break the image
            }
        }
        if (row == 4) {
            iv_41.setImageResource(blankImage); //set the imageresource to blankimage
            iv_42.setImageResource(blankImage); //set the imageresource to blankimage
            iv_43.setImageResource(blankImage); //set the imageresource to blankimage

            switch (place) {
                case 1:
                    iv_41.setImageResource(tapImage1);  //set the imageresource to tapImage1
                    break; //break the image
                case 2:
                    iv_42.setImageResource(tapImage2);  //set the imageresource to tapImage2
                    break; //break the image
                case 3:
                    iv_43.setImageResource(tapImage3);  //set the imageresource to tapImage3
                    break; //break the image
            }
        }

    }
}
