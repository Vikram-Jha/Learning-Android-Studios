package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public void chooliyatumne(View view){
        EditText nameEditText1 = (EditText) findViewById(R.id.nameEditText1);
        EditText nameEditText2 = (EditText) findViewById(R.id.nameEditText2);

        Log.i("Email", nameEditText1.getText().toString());
        Log.i("Password", nameEditText2.getText().toString());
        Log.i("Infomation","Logged IN!");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}