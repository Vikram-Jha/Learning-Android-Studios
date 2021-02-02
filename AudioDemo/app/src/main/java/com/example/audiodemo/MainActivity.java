package com.example.audiodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
//
//    //Nothing Working as explained in this audio  video bhenchod!!!
//       MediaPlayer mediaPlayer;
//    public void button1(View view){
//       mediaPlayer.start();
//    }
//    public void button2(View view){
//        mediaPlayer.pause();
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.palysound); //this code and logic was wrongly explained
        //in the video but check geeksforgeeks for this https://www.geeksforgeeks.org/how-to-add-audio-files-to-android-app-in-android-studio/
        mediaPlayer.start();

    }
}