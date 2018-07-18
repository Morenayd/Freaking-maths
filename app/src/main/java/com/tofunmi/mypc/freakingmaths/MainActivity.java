package com.tofunmi.mypc.freakingmaths;

import android.os.CountDownTimer;
import android.os.RecoverySystem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.lang.*;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView right;
    ImageView wrong;
    ProgressBar timer;
    TextView points;
    TextView question;
    TextView answer;
    ImageView play;
    TextView newPoints;
    Random rand;
    RelativeLayout frontLayout;
    int score;
    int c;
    CountDownTimer countDownTimer;
    LinearLayout gameOverLayout;
    RelativeLayout gameLayout;

    public void choose(View view) {
        if (view.getTag().equals(Integer.toString(c))) {
            Log.i("tag", view.getTag().toString());
            score++;
            points.setText(Integer.toString(score));
            generateQuestion();
        }
        else{
            gameOver();

        }

    }


    public void generateQuestion() {
        countDownTimer.cancel();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        c = rand.nextInt(2);
        int d = rand.nextInt(41);
        question.setText(Integer.toString(a) + "+" + Integer.toString(b));
        if (c == 1) {
            answer.setText("=" + Integer.toString(a + b));
        } else {
            while (d == a + b) {
                d = rand.nextInt(41);
            }
            answer.setText("=" + Integer.toString(d));

        }
        timer.setMax(1500 );
        timer.setProgress(1500);
        countDownTimer.start();



        }

        public void gameOver(){
            newPoints.setText(Integer.toString(score));
            gameOverLayout.setVisibility(View.VISIBLE);
            //gameLayout.setVisibility(View.INVISIBLE);
            play.setVisibility(View.VISIBLE);
            wrong.setEnabled(false);
            right.setEnabled(false);
        }

        public void play(View view){
            gameOverLayout.setVisibility(View.INVISIBLE);
            play.setVisibility(View.INVISIBLE);
           // gameLayout.setVisibility(View.VISIBLE);
            score = 0;
            generateQuestion();
            wrong.setEnabled(true);
            right.setEnabled(true);
        }
        public void playB(View view){
            frontLayout.setVisibility(View.INVISIBLE);
            gameLayout.setVisibility(View.VISIBLE);
            generateQuestion();
        }

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            rand = new Random();
            right = (ImageView) findViewById(R.id.right);
            wrong = (ImageView) findViewById(R.id.wrong);
            timer = (ProgressBar) findViewById(R.id.timer);
            points = (TextView) findViewById(R.id.points);
            question = (TextView) findViewById(R.id.question);
            answer = (TextView) findViewById(R.id.answer);
            gameOverLayout = (LinearLayout) findViewById(R.id.gameOverLayout);
            play = (ImageView) findViewById(R.id.play);
            newPoints = (TextView) findViewById(R.id.newPoints);
            gameLayout = (RelativeLayout) findViewById(R.id.gameLayout);
            frontLayout = (RelativeLayout) findViewById(R.id.frontLayout);
            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            countDownTimer = new CountDownTimer(1510, 10) {

                @Override
                public void onTick(long millisUntilFinished) {
                    timer.setProgress((int) millisUntilFinished );
                }

                @Override
                public void onFinish() {
                    timer.setProgress(0);
                    gameOver();
                }
            };

        }
    }

