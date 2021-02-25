package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.sharedprefrences", Context.MODE_PRIVATE);
        //Stores the data in phones storage in key value pairs
        // Even after commenting out below line of code the data was saved in the app
        // after restarting the application it worked out nicely
        //sharedPreferences.edit().putString("Username","Vikram").apply();

        //
        //String username = sharedPreferences.getString("Username","");
        //Log.i("This is user name",username);



        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.sharedprefrences", Context.MODE_PRIVATE);
        ArrayList<String> friends = new ArrayList<>();
        friends.add("Fido");
        friends.add("Sarah");
        friends.add("John");

      try {
          sharedPreferences.edit().putString("friends",ObjectSerializer.serialize(friends)).apply();
      } catch (Exception e){
          e.printStackTrace();
      }

      ArrayList<String> newFriends = new ArrayList<>();
        try {
    newFriends = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("friends", ObjectSerializer.serialize(new ArrayList<>())));
        } catch (Exception e){
            e.printStackTrace();
        }
        Log.i("Friends",newFriends.toString());
    }
}