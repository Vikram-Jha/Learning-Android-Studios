package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //0 :yellow,1:red,2:empty
    int activeplayer=0;
    int [] gameState={2,2,2,2,2,2,2,2,2};
    int [][] winningPositons = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameActive = true;
    public void dropIn (View view){
        ImageView counter = (ImageView) view;
        int tappedcount = Integer.parseInt(counter.getTag().toString());
        if(gameState[tappedcount] == 2 && gameActive) {
            gameState[tappedcount] = activeplayer;
            counter.setTranslationY((-1500));
            if (activeplayer == 0) {
                activeplayer = 1;
                counter.setImageResource(R.drawable.yellow);
            } else {
                activeplayer = 0;
                counter.setImageResource(R.drawable.red);
            }
            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
            for (int[] winningPositon : winningPositons) {
                if (gameState[winningPositon[0]] == gameState[winningPositon[1]] && gameState[winningPositon[1]] == gameState[winningPositon[2]] && gameState[winningPositon[0]] != 2) {
                    //Someone has won!
                    gameActive=false;
                    String winner = "";
                    if (activeplayer == 1) {
                        winner = "Yellow";
                    } else {
                        winner = "Red";
                    }
                    Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                    TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
                    winnerTextView.setText(winner + " has Won !");
                    playAgainButton.setVisibility(View.VISIBLE);
                    winnerTextView.setVisibility(View.VISIBLE);
                }
            }
        }
    }
        public void playAgain (View view){
            Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
            TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
            playAgainButton.setVisibility(View.INVISIBLE);
            winnerTextView.setVisibility(View.INVISIBLE);

            GridLayout mygridLayout = findViewById(R.id.gridLayout);

            for(int i=0; i<mygridLayout.getChildCount(); i++)
            {
                ImageView counter = (ImageView) mygridLayout.getChildAt(i);
                counter.setImageDrawable(null);
            }
            for(int i = 0 ; i<gameState.length;i++) {
                gameState[i] =2;
            }
            activeplayer = 0;
            gameActive = true;
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}