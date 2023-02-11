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
    Card cardMatch1, cardMatch2;
    int matchesFound = 0;


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
        Collections.shuffle(Arrays.asList(deck));
        for(int x = 0; x < row; x++)
        {
            TableRow tr = (TableRow) board.getChildAt(x);
            for(int y = 0; y < col; y++)
            {
                ImageView iv = (ImageView) tr.getChildAt(y);
                cards[x][y] = new Card(x,y);
                cards[x][y].setFaceID(deck[count % deck.length]);
                iv.setImageResource(cards[x][y].getFaceID());
                count++;
            }

        }

    }


    public void compareCards(ImageView imageView, Card card)
    {
        if(cardMatch1 == null)
        {
            cardMatch1 = card;
            imageView.setImageResource(cardMatch1.getFaceID());
        }
        else{
            cardMatch2 = card;
            imageView.setImageResource(cardMatch2.getFaceID());

            if(cardMatch1.getFaceID() == cardMatch2.getFaceID())
            {
                matchesFound++;
                if(matchesFound == 6)
                {
                    winCondition();
                }
            }
            cardMatch1 = null;
            cardMatch2 = null;
        }
    }

    public void winCondition()
    {
        Intent intent = new Intent(this, WinScrene.class);
        intent.putExtra("matches", matchesFound);
        startActivityForResult(intent, 1);

    }






}