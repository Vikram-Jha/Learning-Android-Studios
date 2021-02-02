package com.example.basicphrases;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public void clicked(View view){
        Button buttonPressed = (Button) view;

        MediaPlayer mediaPlayer= MediaPlayer.create(this, getResources().getIdentifier(buttonPressed.getTag().toString(), "raw", getPackageName()));
        // getResources().getIdentifier(buttonPressed.getTag().toString(), "raw", getPackageName()) does for what usually R.raw.filname does in case of generic fuction
        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}