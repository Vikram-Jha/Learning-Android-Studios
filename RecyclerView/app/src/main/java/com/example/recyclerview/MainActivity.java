package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mrecyclerView;
    LinearLayoutManager layoutManager;   //layout Manager
    List<ModelClass> userList;       // List of ModelClass Class Nature
    Adapter adapter;                //Adapter which will set the values in recycler view

     /*RecyclerView is a ViewGroup added to the android studio as a successor of the GridView and ListView.
It is an improvement on both of them and can be found in the latest v-7 support packages.

It has been created to make possible construction of any lists with XML layouts as an item which can
be customized vastly while improving on the efficiency of ListViews and GridViews.

This improvement is achieved by recycling the views which are out of the visibility of the user.
For example, if a user scrolled down to a position where items 4 and 5 are visible; items 1, 2, and 3
would be cleared from the memory to reduce memory consumption.

Implementation: To implement a basic RecyclerView three sub-parts are needed to be constructed which
offer the users the degree of control they require in making varying designs of their choice.

1. The Card Layout: The card layout is an XML layout which will be treated as an item for the list
created by the RecyclerView.

2. The ViewHolder: The ViewHolder is a java class that stores the reference to the card
layout views that have to be dynamically modified
during the execution of the program by a list of data obtained either by online databases
or added in some other way.

3. The Data Class: The Data class is a custom java class that acts as a structure for
holding the information for every item of the RecyclerView.
Below is the implementation of the RecyclerView:*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();       // To add data function just after application opens
        initRecyclerView();    //Filed the data in recycler view
    }

    private void initRecyclerView() {

        mrecyclerView=findViewById(R.id.RecyclerView);

        layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(RecyclerView.VERTICAL); //Vertical is used to generate the message like items
                                                             // Horizontal is used to generate pages like we scroll from messages to status in whatsapp.

        mrecyclerView.setLayoutManager(layoutManager); //Layout manager gives control to recycler view

        adapter=new Adapter(userList);

        mrecyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

    }
    private void initData() {
        userList = new ArrayList<>();

        userList.add(new ModelClass(R.drawable.download,"Anjali","How are you?","10:45 am","_______________________________________"));

        userList.add(new ModelClass(R.drawable.downloasd,"Vikram Jha","I am fine","15:08 pm","_______________________________________"));

        userList.add(new ModelClass(R.drawable.sasdasas,"Sam","You Know?","1:02 am","_______________________________________"));

        userList.add(new ModelClass(R.drawable.sj,"Divya","How are you?","12:55 pm","_______________________________________"));

        userList.add(new ModelClass(R.drawable.download,"Simran","This is Easy","13:50 am","_______________________________________"));

        userList.add(new ModelClass(R.drawable.sasdasas,"Karan","I am Don","1:08 am","_______________________________________"));

        userList.add(new ModelClass(R.drawable.downloasd,"Sameer","You Know this?","4:02 am","_______________________________________"));

        userList.add(new ModelClass(R.drawable.sj,"Baby","How ?","11:55 pm","_______________________________________"));

        userList.add(new ModelClass(R.drawable.download,"Anjali","How are you?","10:45 am","_______________________________________"));

        userList.add(new ModelClass(R.drawable.downloasd,"Vikram Jha","I am fine","15:08 pm","_______________________________________"));

        userList.add(new ModelClass(R.drawable.sasdasas,"Sam","You Know?","1:02 am","_______________________________________"));

        userList.add(new ModelClass(R.drawable.sj,"Divya","How are you?","12:55 pm","_______________________________________"));

        userList.add(new ModelClass(R.drawable.download,"Simran","This is Easy","13:50 am","_______________________________________"));

        userList.add(new ModelClass(R.drawable.sasdasas,"Karan","I am Don","1:08 am","_______________________________________"));

        userList.add(new ModelClass(R.drawable.downloasd,"Sameer","You Know this?","4:02 am","_______________________________________"));

        userList.add(new ModelClass(R.drawable.sj,"Baby","How ?","11:55 pm","_______________________________________"));

    }


}