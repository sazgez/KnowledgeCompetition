package com.devapp.competition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    // varibales
    Intent get_intent;
    int score;
    // views
    TextView textViewScore, textViewMessage;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // binding views
        textViewScore = (TextView) findViewById(R.id.textViewScore);
        textViewMessage = (TextView) findViewById(R.id.textViewMessage);
        imageView = (ImageView) findViewById(R.id.imageView);
        // get the contents of QuestionActivity
        get_intent = getIntent();
        // assigning the contents
        score = get_intent.getIntExtra("score", 0);
        // set the score in text
        textViewScore.setText("Your Score: " + score);
        // set the proper image & message according to the score
        if(score >= 0 && score <= 3) // 0-3
        {
            imageView.setImageResource(R.drawable.give_up);
            textViewMessage.setText("The image explains everything...");
        }
        else if(score > 3 && score <= 6) // 4-6
        {
            imageView.setImageResource(R.drawable.better);
            textViewMessage.setText("Great. Could be better though.");
        }
        else // 7-10
        {
            imageView.setImageResource(R.drawable.great_job);
            textViewMessage.setText("Congrats, you made a nice job!");
        }
    }

    @Override
    public void onBackPressed() {
        // preventing to go back
    }
}