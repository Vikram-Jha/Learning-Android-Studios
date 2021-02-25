package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE,null);

        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

        myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Nick',45)");
        myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Nick',43)");
        myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Tom',4)");

//        myDatabase.execSQL("DELETE FROM Users WHERE name= 'Nick'"); //DOESN'T DELETE A UNIQUE NICK USING LIMIT

        Cursor c = myDatabase.rawQuery("SELECT * FROM users ",null);
//
//        Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE age>18",null);

//        Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name='Nick'",null);

//        Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name='Nick' AND age=43",null);

//        Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE 'N%'",null);



//        Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE '%o%'",null);
//        Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE '%o%' LIMIT 1",null);
        int IndexOfName = c.getColumnIndex("name");

        int IndexOfAge = c.getColumnIndex("age");


        c.moveToFirst();

        while (c!=null){
            Log.i("name",c.getString(IndexOfName));
            Log.i("age",c.getString(IndexOfAge));

            c.moveToNext();
        }

    }
}