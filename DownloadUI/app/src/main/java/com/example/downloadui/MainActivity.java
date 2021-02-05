package com.example.downloadui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public class DownloadTask extends AsyncTask <String, Void, String>{
        @Override
        protected String doInBackground(String... strings) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection= null;

            try {
                url = new URL(strings[0]);
                urlConnection =(HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while(data != -1){
                    data= reader.read();
                    char current = (char) data;
                    result += current;
                }
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return "failed";
            }

//            Log.i("Url",strings[0]);
//
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadTask task = new DownloadTask();
        String result=null;
        try {
            result= task.execute("https://www.geeksforgeeks.org/").get();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Log.i("Result", result);
    }
}