package com.example.timetablemytry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView myListView;
        public void generateTable(int tableNumber){
            ArrayList<Integer> table = new  ArrayList<Integer>();
            table.add(tableNumber*1);
            table.add(tableNumber*2);
            table.add(tableNumber*3);
            table.add(tableNumber*4);
            table.add(tableNumber*5);
            table.add(tableNumber*6);
            table.add(tableNumber*7);
            table.add(tableNumber*8);
            table.add(tableNumber*9);
            table.add(tableNumber*10);
            ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1,table);
            myListView.setAdapter(arrayAdapter);
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ///////////////////////CODE STARTS HERE////////////////////////
        int maxTableNumber = 20;
        int startingPosition =10;
        SeekBar tableControl = (SeekBar) findViewById(R.id.seekBar);
        myListView = findViewById(R.id.myListView);
        tableControl.setMax(maxTableNumber);
        tableControl.setProgress(startingPosition);
        generateTable(startingPosition);
//        Require SeekBar with range [Min, Max] and INCREMENT value,
// However, Android Seekbar starts from 0 and increment is 1 by default, Android supports min attr on API 26,
// To make a increment & range Seekbar, we can do the following conversion:
//
//     seekbar.setMax((Max - Min) / Increment)
//     seekbar.setProgress((actualValue - Min) / Increment)
//     seekbar.getProgress = Min + (progress * Increment)
//
// The RangeSeekBar is responsible for handling all these logic inside the class.

        tableControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int tableNumber;
                if(progress<min){
                    tableNumber =min;
                    tableControl.setProgress(min);
                }
                else{
                    tableNumber=progress;
                }
                generateTable(tableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}