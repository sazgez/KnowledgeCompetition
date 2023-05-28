package com.devapp.competition;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    // views
    TextView textViewTitle, textViewScore, textViewMessage;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // binding views
        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        textViewScore = (TextView) findViewById(R.id.textViewScore);
        textViewMessage = (TextView) findViewById(R.id.textViewMessage);
        imageView = (ImageView) findViewById(R.id.imageView);
        // set the proper title
        if(CategoryActivity.counter == 10)
            textViewTitle.setText("You've answered all questions");
        else
            textViewTitle.setText("There is unanswered questions");
        // set the score in text
        textViewScore.setText("Your Score: " + CategoryActivity.score);
        // set the proper image & message according to the score
        if(CategoryActivity.score >= 0 && CategoryActivity.score <= 3) // 0-3
        {
            imageView.setImageResource(R.drawable.give_up);
            textViewMessage.setText("The image explains everything...");
        }
        else if(CategoryActivity.score > 3 && CategoryActivity.score <= 6) // 4-6
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