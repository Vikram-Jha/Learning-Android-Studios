package com.example.katrinakaid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void clickon(View view){
        Log.i("Info :","Clicked !");
        ImageView image = (ImageView) findViewById(R.id.imageView1);
        image.setImageResource(R.drawable.catswitch);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}