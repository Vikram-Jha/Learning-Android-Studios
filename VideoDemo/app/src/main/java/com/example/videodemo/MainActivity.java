package com.example.videodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Create a new folder raw inside the res folder by right clicking on res folder
        // and clicking on show explorer and paste your video inside that for latter use
        // Create a VideoView in the layout
        // we are writing here in on create since we want to play the video as soon we open the app
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        VideoView videoView=(VideoView) findViewById(R.id.videoView); //Setting up a videoview variable for using the fuctions of vedioview

        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.the_video); //Setting up the Video path for access

        //Giving the user to go back and forth in the app and stop the view

        MediaController mediaController = new MediaController(this); //Setting MediaController for a particular this app

        mediaController.setAnchorView(videoView);  //Making the media controller anchor the app

        videoView.setMediaController(mediaController); //Making Declared MediaController for the current video

        videoView.start(); // to start up the app
    }
}