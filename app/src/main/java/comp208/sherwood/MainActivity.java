package comp208.sherwood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int row = 4;
    int col = 3;
    Card[][] cards = new Card[row][col];
    TableLayout board;
    Card cardMatch1, cardMatch2; // this will compare the two cards id values
    int matchesFound = 0; // this will record the amount of matches


    // this array stores all the face card images
   int[] deck = {
           R.drawable.shape1,
           R.drawable.shape2,
           R.drawable.shape3,
           R.drawable.shape4,
           R.drawable.shape5,
           R.drawable.shape6
   };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        board =(TableLayout) findViewById(R.id.matchTable);
        setUp();
    }

    public void setUp(){
        int count = 0;
        Collections.shuffle(Arrays.asList(deck)); // shuffles the card faces
        for(int x = 0; x < row; x++)
        {
            TableRow tr = (TableRow) board.getChildAt(x); // sets the x axis values
            for(int y = 0; y < col; y++)
            {
                ImageView iv = (ImageView) tr.getChildAt(y); // sets the y axis values
                cards[x][y] = new Card(x,y);
                // each of the loops it goes through will set a face id for a card face
                cards[x][y].setFaceID(deck[count % deck.length]);
                iv.setImageResource(cards[x][y].getFaceID()); // sets the image
                count++; // will add to the counter for the assining of id's to the ui layer
            }
        }

    }


    /*
    * when the user clicks on the card it will assign value to the card match
    * to store the Id then compare the other clicked card, if they are the
    * same then they will add one to matches found if 6 matches are
    * found the win condition method is called*/
    public void compareCards(ImageView imageView, Card card)
    {
        if(cardMatch1 == null)
        {
            cardMatch1 = card;
            // stores the id of a card into cardMatch1 if it's the first one being clicked
            imageView.setImageResource(cardMatch1.getFaceID());
        }
        else{
            // if second card is being selected it stores the id value in cardMatch2
            cardMatch2 = card;
            imageView.setImageResource(cardMatch2.getFaceID());

            // compares the two values to see if they are the same
            if(cardMatch1.getFaceID() == cardMatch2.getFaceID())
            {
                matchesFound++; // adds one to matches found
                if(matchesFound == 6)
                {
                    winCondition();
                }
            }
            // if both cards do not match set them back to null until next selection
            cardMatch1 = null;
            cardMatch2 = null;
        }
    }

    // when the player wins they will go to the winScrene activity
    public void winCondition()
    {
        Intent intent = new Intent(this, WinScrene.class);
        // this will pass the value of matchesFound to be displayed in the WinScrene imageView
        intent.putExtra("matches", matchesFound);
        startActivityForResult(intent, 1);

    }






}