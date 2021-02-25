package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 /*       ////////Handler allow us to do some timing functions///////
        final Handler handler = new Handler();
        /////Handle runs the runnable /////////////////////
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.i("Hey ! It's us","A second just passed");
                handler.postDelayed(this,1000);
            }
        };
        handler.post(run);
  */
        //Another way of doing it

        //CountDownTime is built in class which calculated the value of current time and decreases it automatically
        //onTick and onFinish are its member function/member method.
        new CountDownTimer(10000,1000){ //10000 ms =10sec is upper limeit which means timer will run for 10sec
            // and its interval period is of 1sec. 1000ms = 1second
            @Override
            public void onTick(long milliSecondsUntilDone){ //OnEvery interval that's tick it executes a function OnTick

                Log.i("Seconds Left !",String.valueOf(milliSecondsUntilDone/1000));
            }

            public void onFinish(){        ////OnFinish i.e when timer end, it executes a function OnFinish
                Log.i("No more countdown","Timer value reached the end.");
            }

        }.start(); //.start() starts the timer as soon app is open
    }
}