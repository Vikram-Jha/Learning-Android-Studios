package com.example.convertexdollars2rupees;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        public void onButton(View view){

        Log.i("Values","Button Pressed!");
        EditText editText = (EditText) findViewById(R.id.editText);
        String Dollarsinstring = editText.getText().toString();
        double dollarsindouble = Double.parseDouble(Dollarsinstring);
        double rupeesindouble = dollarsindouble * 73.21;
        String formatTextRupees = String.format ("%.2f",rupeesindouble);
        Toast.makeText(this,Dollarsinstring +" $ is  Rs. "+formatTextRupees, Toast.LENGTH_LONG).show();


        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}