package com.example.logindemo; // name of our package that we have created

import androidx.appcompat.app.AppCompatActivity; //Make the data editable
import android.os.Bundle; //Default Android Binddle application
import android.util.Log; // Files which we import to work with Logcat
import android.view.View; // files to make View work
import android.widget.EditText; // File to make edit text works
import android.widget.Toast; // files to make the toast working

public class MainActivity extends AppCompatActivity { //WE ARE ACTUALLY EXTENDING THE FUNCTIINALITY OF THE APPCOMPACTIVITY FILE THATS WHY ITS OPENED IN EXTENED FORM
    /*EXAMPLE OF MULTILINE COMMENT IN JAVA
    * SAME AS C++/C*/

    public void clickon(View view) {

        //clickon is name of funtion which gets evoked on clicking the button we have given that name to funtion in the attribute of buttons
        //View is a tupe of data in java and view is name of data with wich our clickon funtion is feed with
        EditText userName = (EditText) findViewById(R.id.userTextView);
        EditText passwordText = (EditText) findViewById(R.id.passTextView);

        Log.i("Email", userName.getText().toString()); // TO show information in the log itself
        Log.i("Password", passwordText.getText().toString()); //.getText() USED TO CONVERT EDIT TEXT TO TEXT AND toString() IS USED TO CONVERT FROM TEXT TO STRING
        Log.i("Info.", "Logged In!");

        Toast.makeText(this,"Logged In "+ userName.getText().toString(),Toast.LENGTH_LONG).show(); //logged in + some funtion to concatenate the strings
        //Lenght_Long show the toast for long and length_short show the toast for small period of time
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}