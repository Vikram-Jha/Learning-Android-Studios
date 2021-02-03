package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //      very important topic is list all the info in facebook scroll, google scroll and song list and everything almost are made up of list
 //       SUCCESSFULL CREATING A LISTVIEW
//        ListView myListView = (ListView) findViewById(R.id.myListView);
////      making an arraylist of string type and then passing name of family member to it
//        ArrayList<String> myFamily = new ArrayList<String>();
//
//        myFamily.add("Vikram Jha");
//        myFamily.add("Lallan Jha");
//        myFamily.add("Kalewar Jha");
//        myFamily.add("Jyoti Jha");
//
//        //creating a method in which after clicking on one of the name or name name sothing happens
//        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            //CREATING A CLICK LISTENER TO MAKE THE APP DO SOME ACTIVITY UPON CLICKING THE NAME
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i("Person Selected", myFamily.get(position));
//            }
//        });
//          Create an array adapter that will hold our list
////        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,myFamily);
////        SETTING listview value to array list as given
////        myListView.setAdapter(arrayAdapter);
//          
//          CREATING A LARGE ENOUGH LIST TO SEE SCROLLING FUCTION IN IT ALSO
////        myFamily.add("Vikram Jha");
////        myFamily.add("Lallan Jha");
////        myFamily.add("Kalewar Jha");
////        myFamily.add("Jyoti Jha");myFamily.add("Vikram Jha");
////        myFamily.add("Lallan Jha");
////        myFamily.add("Kalewar Jha");
////        myFamily.add("Jyoti Jha");myFamily.add("Vikram Jha");
////        myFamily.add("Lallan Jha");
////        myFamily.add("Kalewar Jha");
////        myFamily.add("Jyoti Jha");myFamily.add("Vikram Jha");
////        myFamily.add("Lallan Jha");
////        myFamily.add("Kalewar Jha");
////        myFamily.add("Jyoti Jha");myFamily.add("Vikram Jha");
////        myFamily.add("Lallan Jha");
////        myFamily.add("Kalewar Jha");
////        myFamily.add("Jyoti Jha");myFamily.add("Vikram Jha");
////        myFamily.add("Lallan Jha");
////        myFamily.add("Kalewar Jha");
////        myFamily.add("Jyoti Jha");myFamily.add("Vikram Jha");
////        myFamily.add("Lallan Jha");
////        myFamily.add("Kalewar Jha");
////        myFamily.add("Jyoti Jha");myFamily.add("Vikram Jha");
////        myFamily.add("Lallan Jha");
////        myFamily.add("Kalewar Jha");
////        myFamily.add("Jyoti Jha");myFamily.add("Vikram Jha");
////        myFamily.add("Lallan Jha");
////        myFamily.add("Kalewar Jha");
////        myFamily.add("Jyoti Jha"); 

        
        //challenge
        
        ListView myListView = findViewById(R.id.myListView);
        
        final ArrayList<String> myFriends = new ArrayList<String>(asList("Vikram","Shreyam","Krishna","Chandan","Satyam"));
//        ArrayList<String> myFriends = new ArrayList<String>();
//        myFriends.add("Vikram");
//        myFriends.add("Satyam");
//        myFriends.add("Chandan");
//        myFriends.add("Shreyam");
//        myFriends.add("Krishna");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,myFriends);

        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                        //CREATING A CLICK LISTENER TO MAKE THE APP DO SOME ACTIVITY UPON CLICKING THE NAME
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Hello! " + myFriends.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        
        myListView.setAdapter(arrayAdapter);
    }
}