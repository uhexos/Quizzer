package com.example.android.quizzer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {


    public static final String EXTRA_MESSAGE = "com.example.android.userScore.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void submit(View view) {
        String correctlyAnsweredQuestionNumbers = "";
        RadioButton q1 = (RadioButton) findViewById(R.id.q1ans);
        RadioButton q2 = (RadioButton) findViewById(R.id.q2ans);
        CheckBox q3A = (CheckBox) findViewById(R.id.q3Aans);
        CheckBox q3B = (CheckBox) findViewById(R.id.q3Bans);
        EditText q4 = (EditText) findViewById(R.id.q4Ans);
        RadioButton q5 = (RadioButton) findViewById(R.id.q5ans);
        int score;

        //this checks if the appropriate options have been selected and increases the score
        score = 0;
        if (q1.isChecked()) {
            score++;
            correctlyAnsweredQuestionNumbers += " " + "1";
        }
        if (q2.isChecked()) {
            score++;
            correctlyAnsweredQuestionNumbers += " " + "2";
        }
        if (q3A.isChecked()) {
            score++;
            correctlyAnsweredQuestionNumbers += " " + "3A";
        }
        if (q3B.isChecked()) {
            score++;
            correctlyAnsweredQuestionNumbers += " " + "3B";
        }
        if (q4.getText().toString().equals(Integer.toString(1975))) {
            score++;
            correctlyAnsweredQuestionNumbers += " " + "4";
        }
        if (q5.isChecked()) {
            score++;
            correctlyAnsweredQuestionNumbers += " " + "5";
        }
        //place extras for use in the userScore activity
        Intent intent = new Intent(this, userScore.class);
        intent.putExtra(EXTRA_MESSAGE, Integer.toString(score));
        intent.putExtra("Correct",correctlyAnsweredQuestionNumbers);
        startActivity(intent);
    }

}
