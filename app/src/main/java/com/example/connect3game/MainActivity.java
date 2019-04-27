package com.example.connect3game;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   // 0 for Gray, 1:Brown,2:empty
    int acyivePlayer=0;
    int[] gamestate={2,2,2,2,2,2,2,2,2};//this is showing in starting all the box are empty
    int[][] winningposition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};// winning postions
    boolean gameActive=true;
    public void dropin(View view){

        ImageView counter=(ImageView)view;
        Log.i("tag", counter.getTag().toString());
        int tapcounter=Integer.parseInt(counter.getTag().toString());// assigning tag number to tapcounter
        if(gamestate[tapcounter]==2 && gameActive){
        gamestate [tapcounter]=acyivePlayer;// updating array with active player

        counter.setTranslationY(-1500);//to move up the image
        if(acyivePlayer == 0)
        {
            counter.setImageResource(R.drawable.jerry);// for changeing dynamically image
            acyivePlayer=1;
        }
      else  {
            counter.setImageResource(R.drawable.tom22);// for changeing dynamically image
            acyivePlayer=0;
        }

        counter.animate().translationYBy(1500).rotation(360).setDuration(300);
     for(int[] win:winningposition)
     {
         if(gamestate[win[0]]==gamestate[win[1]]&&gamestate[win[1]]==gamestate[win[2]]&&gamestate[win[0]]!=2){
             // someone has won
             gameActive=false;
             String winner="";
             if(acyivePlayer==1){
                 winner="Gray";
             }
             else{
                 winner="Brown";
             }
         //    Toast.makeText(this, winner+" has won", Toast.LENGTH_SHORT).show();
             Button btn=(Button)findViewById(R.id.button);
             TextView text=(TextView)findViewById(R.id.textView2);
             text.setText(winner+" has won");
             btn.setVisibility(View.VISIBLE);
             text.setVisibility(View.VISIBLE);
         }
      // condition if game is draw
     else {
             boolean full = true;
             for (int key:gamestate){
                 if (key==2){
                     full=false;
                 }
             }
             if(full){
                 Button btn=(Button)findViewById(R.id.button);
             TextView text=(TextView)findViewById(R.id.textView2);
             text.setText(" no one has won");
             btn.setVisibility(View.VISIBLE);
             text.setVisibility(View.VISIBLE);

             }
         }
     }
        }

    }
    public void playAgain(View view){
        Button btn=(Button)findViewById(R.id.button);
        TextView text=(TextView)findViewById(R.id.textView2);
        btn.setVisibility(View.INVISIBLE);
        text.setVisibility(View.INVISIBLE);
        GridLayout gridLayout=(GridLayout)findViewById(R.id.gridlayout);// looping all object through layout
        for(int i=0; i<gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);

            counter.setImageDrawable(null);//remove image from imageview from
        }
// to set all things again

        for(int i=0;i<gamestate.length;i++) {
            gamestate[i] = 2;//this is showing in starting all the box are empty}
        }
        gameActive=true;
        acyivePlayer=0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }}

