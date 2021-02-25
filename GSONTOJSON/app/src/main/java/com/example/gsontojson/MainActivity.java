package com.example.gsontojson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    UserSimple abc = new UserSimple("Norman","norman@futurestud.io",26,true);
    Gson gson = new Gson();
    String userJson = gson.toJson(abc);

    public void clicked(View view){
        Log.i("Data", userJson);
    }

    String userJson2 = "{'age':26,'email':'norman@futurestud.io','isDeveloper':true,'name':'Norman'}";
    Gson gson2 = new Gson();
    UserSimple userObject2 = gson2.fromJson(userJson2,UserSimple.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}