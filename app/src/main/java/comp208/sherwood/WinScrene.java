package comp208.sherwood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WinScrene extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_screne);
        displayScore();
    }

    // this will display the score in the text view
    public void displayScore()
    {
        TextView tv = findViewById(R.id.score); // this text view is connected to the ui
        Intent intent = getIntent();
        // this will use the "matches used in the winCondition method and display how many guess
        int matches = intent.getIntExtra("matches", 0);
    }

    // this will restart the application

    public void restartApp(){
        finish(); // this will close the current activity
    }
    public void quitApp()
    {
        finishAffinity(); // this should close all activities
    }
}