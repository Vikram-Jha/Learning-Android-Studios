package com.example.mausamapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    EditText city;
    Button search;
    TextView message;
    String url;

    class getWeather extends AsyncTask<String , Void , String>{
        @Override
        protected String doInBackground(String... urls) {
            StringBuilder result = new StringBuilder();
           try{
               URL url = new URL(urls[0]);
               HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
               urlConnection.connect();
               InputStream inputStream = urlConnection.getInputStream();
               BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

               String line="";
               while ((line = reader.readLine())!= null){
                   result.append(line).append("\n");

               }
               return result.toString();
           }
           catch (Exception e){
               e.printStackTrace();
               Toast.makeText(getApplicationContext(),"Sorry! Couldn't Find Weather!",Toast.LENGTH_SHORT).show();
               return null;
           }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            try{
                JSONObject jsonObject = new JSONObject(result);
                String weatherInfo ;
//                        = jsonObject.getString("main");
//                {
//                    "coord":{
//                    "lon":77.2167,
//                            "lat":28.6667
//                },
//                    "weather":[
//                    {
//                        "id":711,
//                            "main":"Smoke",
//                            "description":"smoke",
//                            "icon":"50d"
//                    }
//   ],
//                    "base":"stations",
//                        "main":{
//                    "temp":298.81,
//                            "feels_like":299.18,
//                            "temp_min":297.15,
//                            "temp_max":300.15,
//                            "pressure":1015,
//                            "humidity":47
//                },
//                    "visibility":2000,


                String city="City: "+jsonObject.getString("name");
                String WeatherType ="Weather Type: "+jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
                String pressure = "Pressure: "+Integer.toString(jsonObject.getJSONObject("main").getInt("pressure"))+" mBar";
                String humidity = "Humidity: "+Integer.toString(jsonObject.getJSONObject("main").getInt("humidity")) + " %";
                double tempResult=jsonObject.getJSONObject("main").getDouble("temp")-273.15; //degree celcius me dega
                int roundedValue=(int)Math.rint(tempResult);
                String Temperature="Temperature: "+Integer.toString(roundedValue)+" °C";
                weatherInfo = "Fetched Details..."+ "\n" +  "\n" + "\n" +city + "\n" + Temperature +  "\n" + pressure + "\n" + humidity + "\n" + WeatherType ;
                message.setText(weatherInfo);
            }
            catch (Exception e){
                Toast.makeText(getApplicationContext(),"Sorry! Couldn't Find Weather!",Toast.LENGTH_SHORT).show();
                e.printStackTrace();

            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /////////////////////////////////////////////////////////
        message = findViewById(R.id.Message);
        search = findViewById(R.id.search);
        city = findViewById(R.id.city);

        final String[] temp  = {""};

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Finding Weather !", Toast.LENGTH_SHORT).show();
                String cityName = city.getText().toString();

                //changed http to https and it worked like magic??//



                try{
                    InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(message.getWindowToken(), 0);
                    if(cityName != null){
                        url ="https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=bcbf4d9df5b112f893d08e1bd1c3b197";
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Enter City", Toast.LENGTH_SHORT).show();
                    }
                    getWeather task = new getWeather();
                    temp[0] = task.execute(url).get();
                }
                catch (ExecutionException e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"Couldn't Find Weather :(",Toast.LENGTH_SHORT).show();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"Couldn't Find Weather :(",Toast.LENGTH_SHORT).show();
                }

                if(temp[0]==null){
                    message.setText("Cannot find weather !");
                    Toast.makeText(getApplicationContext(),"Couldn't Find Weather :(",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}