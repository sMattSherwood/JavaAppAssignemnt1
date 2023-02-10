package comp208.sherwood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] imgs = {R.drawable.shape1, R.drawable.shape2, R.drawable.shape3,
        R.drawable.shape4, R.drawable.shape5, R.drawable.shape6};
    int row = 3;
    int col = 4;
    Card[][] match = new Card[row][col];
    TableLayout board;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        board = (TableLayout)findViewById(R.id.matchTable);
    }

    public void suffleArray(int[] array, int length)
    {
        Random random = new Random();
        for(int i = length-1; i > 0; i--){
            int j = random.nextInt(i+1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }


    public void setValue()
    {
        for(int x = 0; x < row; x++){
            TableRow tr = (TableRow) board.getChildAt(x);
            for(int y = 0; y < col; y++){
                ImageView iv = (ImageView) board.getChildAt(y);
                match[x][y] = new Card(x,y);
                match[x][y].setFaceID(R.drawable.queston);
                iv.setTag(match[x][y]);
                iv.setImageResource(R.drawable.queston);

            }

        }

    }
}