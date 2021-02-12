package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class MainActivity extends AppCompatActivity {

    EditText city;
    TextView details;

    public void find(View view) {
        try {

            DownloadTask task = new DownloadTask();
            String encodedCityName = URLEncoder.encode(details.getText().toString(), "UTF-8");
            task.execute("https://api.openweathermap.org/data/2.5/weather?q=" + city.getText().toString() + "&appid=bcbf4d9df5b112f893d08e1bd1c3b197");

           //TO COLLAPSE THE KEYBOARD AS SOON AS DATA IS ENTERED !//
            InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(details.getWindowToken(), 0);
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Couldn't Find Weather :(",Toast.LENGTH_SHORT).show();
        }
    }

    public class DownloadTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... urls) {
            String result= "";
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while(data!=-1){
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }
                return result;

            } catch (Exception e){
                e.printStackTrace();

                Toast.makeText(getApplicationContext(),"Couldn't Find Weather :(",Toast.LENGTH_SHORT).show();

                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try{
                JSONObject jsonObject = new JSONObject(s);

                String weatherInfo = jsonObject.getString("weather");

                Log.i("Weather Content", weatherInfo);

                JSONArray jsonArray = new JSONArray(weatherInfo);

                String message = "";

                for(int i=0 ; i<jsonArray.length() ; i++){
                    JSONObject jsonPart = jsonArray.getJSONObject(i);

                    String main = "Main: " + jsonPart.getString("main");
                        String description = "Description: " + jsonPart.getString("description");

//                    Log.i("main",jsonPart.getString("main"));
//                    Log.i("description",jsonPart.getString("description"));
                        if(!main.equals("") && !description.equals("")){
                            message+= main + "\n" +description ;
                        }
                    if(!message.equals("")){
                        details.setText(message);
                    } else{
                        Toast.makeText(getApplicationContext(),"Couldn't Find Weather :(",Toast.LENGTH_SHORT).show();
                    }
                }
//
            } catch (Exception e){
                e.printStackTrace();
                Toast.makeText(getApplicationContext(),"Couldn't Find Weather :(",Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = findViewById(R.id.city);
        details = findViewById(R.id.details);
    }
}