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
    ImageView iv_11, iv_12, iv_13, iv_14,
            iv_21, iv_22, iv_23, iv_24,
            iv_31, iv_32, iv_33, iv_34,
            iv_41, iv_42, iv_43, iv_44,
            iv_51, iv_52, iv_53, iv_54;
    Button buttonply;
    TextView time_remain, number_score, number_best;
    Random r;
    int rockLocationRow1, rockLocationRow2, rockLocationRow3, rockLocationRow4, rockLocationRow5;
    int tapImage1, tapImage2, tapImage3, tapImage4, blankImage, frameImage;
    int currentScore = 0;
    int bestScore = 0;
    CountDownTimer timer3;
    Timer timer2;
    MediaPlayer mp;

    // Timer timer;
    // Timer timer2;
    //MediaPlayer mp;
    //MediaPlayer mp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_one);
        mp = MediaPlayer.create(song_one.this, R.raw.sparkoflightsong);
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                mp.start();
            }
        }, 3000);
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        bestScore = preferences.getInt("highscore", 0);

        iv_11 = (ImageView) findViewById(R.id.iv_11);
        iv_12 = (ImageView) findViewById(R.id.iv_12);
        iv_13 = (ImageView) findViewById(R.id.iv_13);
        iv_14 = (ImageView) findViewById(R.id.iv_14);

        iv_21 = (ImageView) findViewById(R.id.iv_21);
        iv_22 = (ImageView) findViewById(R.id.iv_22);
        iv_23 = (ImageView) findViewById(R.id.iv_23);
        iv_24 = (ImageView) findViewById(R.id.iv_24);

        iv_31 = (ImageView) findViewById(R.id.iv_31);
        iv_32 = (ImageView) findViewById(R.id.iv_32);
        iv_33 = (ImageView) findViewById(R.id.iv_33);
        iv_34 = (ImageView) findViewById(R.id.iv_34);

        iv_41 = (ImageView) findViewById(R.id.iv_41);
        iv_42 = (ImageView) findViewById(R.id.iv_42);
        iv_43 = (ImageView) findViewById(R.id.iv_43);
        iv_44 = (ImageView) findViewById(R.id.iv_44);

        iv_51 = (ImageView) findViewById(R.id.iv_51);
        iv_52 = (ImageView) findViewById(R.id.iv_52);
        iv_53 = (ImageView) findViewById(R.id.iv_53);
        iv_54 = (ImageView) findViewById(R.id.iv_54);

        buttonply = (Button) findViewById(R.id.buttonply);

        number_score = (TextView) findViewById(R.id.number_score);
        number_score.setText("SCORE: " + currentScore);

        number_best = (TextView) findViewById(R.id.number_best);
        number_best.setText("SCORE: " + bestScore);

        time_remain = (TextView) findViewById(R.id.time_remain);
        time_remain.setText("TIME: " + millisToTime(163000));
        r = new Random();
        loadImages();
        timer3 = new CountDownTimer(163000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time_remain.setText("TIME: " + millisToTime(millisUntilFinished) + 1);
            }


            @Override
            public void onFinish() {
                time_remain.setText("TIME: " + millisToTime(0));

                iv_31.setEnabled(false);
                iv_32.setEnabled(false);
                iv_33.setEnabled(false);
                iv_34.setEnabled(false);
                buttonply.setVisibility(View.VISIBLE);

                iv_11.setImageResource(blankImage);
                iv_12.setImageResource(blankImage);
                iv_13.setImageResource(blankImage);
                iv_14.setImageResource(blankImage);

                iv_21.setImageResource(blankImage);
                iv_22.setImageResource(blankImage);
                iv_23.setImageResource(blankImage);
                iv_24.setImageResource(blankImage);

                iv_31.setImageResource(blankImage);
                iv_32.setImageResource(blankImage);
                iv_33.setImageResource(blankImage);
                iv_34.setImageResource(blankImage);

                iv_41.setImageResource(blankImage);
                iv_42.setImageResource(blankImage);
                iv_43.setImageResource(blankImage);
                iv_44.setImageResource(blankImage);

                iv_51.setImageResource(blankImage);
                iv_52.setImageResource(blankImage);
                iv_53.setImageResource(blankImage);
                iv_54.setImageResource(blankImage);

                Toast.makeText(song_one.this, "Game Over!", Toast.LENGTH_SHORT).show();
                if (currentScore > bestScore) {
                    bestScore = currentScore;
                    number_best.setText("BEST: " + bestScore);
                    SharedPreferences preferences1 = getSharedPreferences("PREFS", 0);
                    SharedPreferences.Editor editor = preferences1.edit();
                    editor.putInt("highscore", bestScore);
                    editor.apply();
                }
            }
        };


        iv_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rockLocationRow3 == 1) {
                    continueGame();
                } else {
                    endGame();
                }
            }
        });
        iv_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rockLocationRow3 == 2) {
                    continueGame();
                } else {
                    endGame();
                }
            }
        });
        iv_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rockLocationRow3 == 3) {
                    continueGame();
                } else {
                    endGame();
                }
            }
        });
        iv_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rockLocationRow3 == 4) {
                    continueGame();
                } else {
                    endGame();
                }
            }
        });
        buttonply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initGame();
            }
        });



    }
    public void continueGame(){
        //row5
        rockLocationRow5 = rockLocationRow4;
        setRockLocation(rockLocationRow5, 5);
        //row4
        rockLocationRow4 = rockLocationRow3;
        setRockLocation(rockLocationRow4, 4);

        //row3
        rockLocationRow3 = rockLocationRow2;
        setRockLocation(rockLocationRow3, 3);

        //row2
        rockLocationRow2 = rockLocationRow1;
        setRockLocation(rockLocationRow2, 2);

        //row1
        rockLocationRow1 = r.nextInt(3) + 1;
        setRockLocation(rockLocationRow1, 1);

        currentScore++;
        number_score.setText("SCORE: " + currentScore);
    }

    private void loadImages() {
        frameImage = R.drawable.circle_frame_ic;
        tapImage1 = R.drawable.yellow_circle_ic;
        tapImage2 = R.drawable.green_circle_ic;
        tapImage3 = R.drawable.red_circle_ic;
        tapImage4 = R.drawable.blue_circle_ic;
        blankImage = R.drawable.blankimg;
        frameImage = R.drawable.circle_frame_ic;
    }

    private int millisToTime(long millis) {
        return (int) millis / 1000;
    }

    private void initGame() {
        iv_31.setEnabled(true);
        iv_32.setEnabled(true);
        iv_33.setEnabled(true);
        iv_34.setEnabled(true);
        buttonply.setVisibility(View.INVISIBLE);
        currentScore = 0;
        number_score.setText("SCORE: " + currentScore);
        timer3.start();

        //row5 - nothing
        //row4
        rockLocationRow5 = 2;
        iv_52.setImageResource(frameImage);
        //row5 - nothing
        //row4
        rockLocationRow4 = 2;
        iv_42.setImageResource(tapImage1);
        //row5 - nothing
        //row4
        rockLocationRow3 = 2;
        iv_32.setImageResource(tapImage1);
        //row5 - nothing
        //row4
        rockLocationRow2 = r.nextInt(3) + 1;
        setRockLocation(rockLocationRow2, 2);

        //row5 - nothing
        //row4
        rockLocationRow1 = r.nextInt(3) + 1;
        setRockLocation(rockLocationRow1, 1);
    }

    private void endGame() {
        timer3.cancel();
        iv_31.setEnabled(false);
        iv_32.setEnabled(false);
        iv_33.setEnabled(false);
        iv_34.setEnabled(false);
        buttonply.setVisibility(View.VISIBLE);

        iv_11.setImageResource(blankImage);
        iv_12.setImageResource(blankImage);
        iv_13.setImageResource(blankImage);
        iv_14.setImageResource(blankImage);

        iv_21.setImageResource(blankImage);
        iv_22.setImageResource(blankImage);
        iv_23.setImageResource(blankImage);
        iv_24.setImageResource(blankImage);

        iv_31.setImageResource(blankImage);
        iv_32.setImageResource(blankImage);
        iv_33.setImageResource(blankImage);
        iv_34.setImageResource(blankImage);

        iv_41.setImageResource(blankImage);
        iv_42.setImageResource(blankImage);
        iv_43.setImageResource(blankImage);
        iv_44.setImageResource(blankImage);

        iv_51.setImageResource(blankImage);
        iv_52.setImageResource(blankImage);
        iv_53.setImageResource(blankImage);
        iv_54.setImageResource(blankImage);

        Toast.makeText(song_one.this, "Failed!", Toast.LENGTH_SHORT).show();
    }

    private void setRockLocation(int place, int row) {
        if (row == 1) {
            iv_11.setImageResource(blankImage);
            iv_12.setImageResource(blankImage);
            iv_13.setImageResource(blankImage);
            iv_14.setImageResource(blankImage);

            switch (place) {
                case 1:
                    iv_11.setImageResource(tapImage1);
                    break;
                case 2:
                    iv_12.setImageResource(tapImage2);
                    break;
                case 3:
                    iv_13.setImageResource(tapImage3);
                    break;
                case 4:
                    iv_14.setImageResource(tapImage4);
                    break;
            }
        }
        if (row == 2) {
            iv_21.setImageResource(blankImage);
            iv_22.setImageResource(blankImage);
            iv_23.setImageResource(blankImage);
            iv_24.setImageResource(blankImage);

            switch (place) {
                case 1:
                    iv_21.setImageResource(tapImage1);
                    break;
                case 2:
                    iv_22.setImageResource(tapImage2);
                    break;
                case 3:
                    iv_23.setImageResource(tapImage3);
                    break;
                case 4:
                    iv_24.setImageResource(tapImage4);
                    break;
            }
        }
        if (row == 3) {
            iv_31.setImageResource(blankImage);
            iv_32.setImageResource(blankImage);
            iv_33.setImageResource(blankImage);
            iv_34.setImageResource(blankImage);

            switch (place) {
                case 1:
                    iv_31.setImageResource(tapImage1);
                    break;
                case 2:
                    iv_32.setImageResource(tapImage2);
                    break;
                case 3:
                    iv_33.setImageResource(tapImage3);
                    break;
                case 4:
                    iv_34.setImageResource(tapImage4);
                    break;
            }
        }
        if (row == 4) {
            iv_41.setImageResource(blankImage);
            iv_42.setImageResource(blankImage);
            iv_43.setImageResource(blankImage);
            iv_44.setImageResource(blankImage);

            switch (place) {
                case 1:
                    iv_41.setImageResource(tapImage1);
                    break;
                case 2:
                    iv_42.setImageResource(tapImage2);
                    break;
                case 3:
                    iv_43.setImageResource(tapImage3);
                    break;
                case 4:
                    iv_44.setImageResource(tapImage4);
                    break;
            }
        }
        if (row == 5) {
            iv_51.setImageResource(blankImage);
            iv_52.setImageResource(blankImage);
            iv_53.setImageResource(blankImage);
            iv_54.setImageResource(blankImage);

            switch (place) {
                case 1:
                    iv_51.setImageResource(tapImage1);
                    break;
                case 2:
                    iv_52.setImageResource(tapImage2);
                    break;
                case 3:
                    iv_53.setImageResource(tapImage3);
                    break;
                case 4:
                    iv_54.setImageResource(tapImage4);
                    break;
            }
        }
    }
}

        /*
        timer2.schedule(new TimerTask(){
            @Override
            public void run() {
                mp2.start();
            }
        }, 3000);
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
            Intent intent = new Intent (song_one.this, win_screen.class);
            startActivity(intent);
            mp.start();
            }
        }, 165000);*/