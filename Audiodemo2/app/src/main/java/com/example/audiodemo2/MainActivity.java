package com.example.audiodemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.TimedMetaData;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //Declaring a audioManager for the audio control...
    AudioManager audioManager;
    //.........................................................................//
    //To add a play and pause button to start and stop the audio
    MediaPlayer mediaPlayer;
    public void play(View view){
        mediaPlayer.start(); //CREATED A FUNCTION FOR PLAYING VIDEO
    }
    public void pause(View view){
        mediaPlayer.pause(); //CREATED A FUNCTION FOR PAUSING THE VIDEO
    }
    //...............................................................................//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //WRITING IN OVERDRIVE BECAUSE THE CODE WILL GET EXECUTED AS SOON WE OPEN THE APPLICATION
        setContentView(R.layout.activity_main);
        //for only pause and play.................................................//
        mediaPlayer = MediaPlayer.create(this,R.raw.rockslide); // SET MEDIA PLAYER ACQUIRE OUR AUDIO

        //.................Now we are adding the seekbar to controlling the audio functionality................/
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE); //Creating a local audio manager to get the audio services

        //Taking the maximum volume form the audio device and assigning it into maxVolume Variable
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        //Taking the current volume form the audio device and assigning it into currentVolume Variable
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        //Setting Up A SEEKBAR AND giving it a name of volumeControl
        SeekBar volumeControl = (SeekBar) findViewById(R.id.seekBar);
        //Setting the max limit of seekBar to maxVolume of our device
        volumeControl.setMax(maxVolume);
        //Setting the currrent Value of  seekBar to currentVolume of our device
        volumeControl.setProgress(currentVolume);
        //As the seekBar is changed by the user the sound also change according to that
        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { //We only write then rest of the code comes automatically
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Log.i("SeekBar Changed",Integer.toString(progress));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress,0); //Setting Up the audio in the accordance of where the seekbar progress is.

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //.........................................Now we are adding the seekbar to Mediacontrol functionality................/

        SeekBar mediaSeekBar = (SeekBar) findViewById(R.id.MediaseekBar);
        //Setting the max limit of seekBar to duration of our audio
        mediaSeekBar.setMax(mediaPlayer.getDuration());

        mediaSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Mediaseekbar", Integer.toString(progress));
                //As we click at any postion the audio goes to that position
                // for ex. if we click at 10 which is 10sec of audio the audio seeks to 10th sec
                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //...................Concept of timer to regularly update our mediaseekbar in the app as the audio plays................/

        new Timer().scheduleAtFixedRate(new TimerTask() { //creating a new time and a new timerTask to IT..
            @Override
            public void run() {
                mediaSeekBar.setProgress(mediaPlayer.getCurrentPosition()); // Updating media seekbar every second to the current possition of the media(audio)
            }
        },0,1000); //We want to start this timer task at time 0 and update it every 1sec=1000milliseconds
    }
}