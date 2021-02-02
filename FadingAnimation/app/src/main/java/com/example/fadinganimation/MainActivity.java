package com.example.fadinganimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

//    boolean bartIsShowing=true;
    public void fade(View view){
        //Making click functionality loopy by making app change image every single time when image is clicked
        //Fade is A image onclick function when ever the image gets clicked it will get invoked.
        Log.i("Info","Image Clicked !");
        //Show info in log that a click has been made on the image
        ImageView bartImageView = (ImageView) findViewById(R.id.bartImage);

        // Setting up bartImageView as ImageVariable for latter use
        // findViewById Returns an Integer Value and Must Be Converted to an ImageView Variable
//        ImageView homerImageView = (ImageView) findViewById(R.id.homerImage);

//        if(bartIsShowing) {
//            bartIsShowing=false;
//            bartImageView.animate().alpha(0).setDuration(2000);
//            //2000 is in millisecond so actually its 2 second itsleft ,
//            // alpha is used to have a fade effect, zero alpha means completely fadded image and 1 means completly opaque images.
//            //fading away bart and making homer come using animation.
//            homerImageView.animate().alpha(1).setDuration(2000);
//        }
//        else {
//            bartIsShowing=true;
//            bartImageView.animate().alpha(1).setDuration(2000);
//
//            homerImageView.animate().alpha(0).setDuration(2000);
//            //fading away homer and make bart come back
//        }

        /*--------------------Other Animations Here------------------------------------------*/

//        TRANSLATION ANIMATION

//        bartImageView.animate().translationYBy(1500).setDuration(2000);
        //this line make bart go in the downward direction slowly and go complete off the screen.
//        bartImageView.animate().translationYBy(-1500).setDuration(2000);
        //this line make bart go in the upwad direction slowly and go complete off the screen.
//        bartImageView.animate().translationXBy(1500).setDuration(2000);
        //this line make bart go in the right direction slowly and go complete off the screen.
//        bartImageView.animate().translationXBy(-1500).setDuration(2000);
//        this line make bart go in the left direction slowly and go complete off the screen.

        //ROTATION ANIMATION
//        bartImageView.animate().rotationX(180).setDuration(1000);
      //  this line make bart rotate the upward direction swing.

        //USING FADING AND ANIMATION TOGETHER
//        bartImageView.animate().rotation(1800).alpha(0).setDuration(2000);
        // This line mark rotate  clockwisely 5 time and it fades as well.

        //SCALING AND ANIMATING TOGETHER
//        bartImageView.animate().scaleX(0.5f).scaleY(0.5f).setDuration(200);
        // we have used and f after 0.5 because scaleX() expects an float while 0.5 is a double

        //CHALLENGE FOR ME
        //MAKE BART APPEAR FROM THE LEFT AND THEN SPIN IT 5 TIMES
        //Solutin:-change the initial postion of image to -1000dp which can be done layout or by coding in @override
        // now i have to write to write make bart disappear in override code which gets executed before starting of an app
        //then we do a translation animation by 1000dp and rotation by 3600 degree i.e 10 times


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView bartImageView = (ImageView) findViewById(R.id.bartImage);
        bartImageView.setX(-1000);
//        bartImageView.animate().translationXBy(-1000); //can be done this way also
        bartImageView.animate().translationXBy(1000).rotation(3600).setDuration(2000);
    }
}