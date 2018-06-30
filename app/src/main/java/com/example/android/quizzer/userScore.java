package com.example.android.quizzer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class userScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_in);
        TextView scoreTextView = (TextView) findViewById(R.id.score);
        TextView correctQuestionTV = (TextView) findViewById(R.id.correctQuestionTextView);
        Intent intent = getIntent();
        //get intent extra from previous activity.
        String score = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String correctQuestions = intent.getStringExtra("Correct");
        scoreTextView.setText(score);
        //check for correct questions and print appropriate messsage
        if (!correctQuestions.equals("")) {
            correctQuestionTV.setText("You answered question " + correctQuestions + " correctly");
        }
        else{
            correctQuestionTV.setText("You answered none correctly");
        }
        //display appropriate message based on score
        giveMessage(score);
    }

    private void giveMessage(String score) {
        //Displays the toast message based on how well the user performed
        try {
            String message;
            int numericScore = Integer.parseInt(score);
            if (numericScore == 6) {
                message = "Perfect Score, you got everything right";
            } else if (numericScore > 3) {
                message = "Congratulations";
            } else {
                message = "You can do better if you believe";
            }
            Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
            toast.show();
        } catch (NumberFormatException e) {
            Log.e("Error in conversion", "check your giveMessage parameter");
        }
    }
}
