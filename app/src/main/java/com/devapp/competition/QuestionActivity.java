package com.devapp.competition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {
    // views
    TextView textViewCategory, textViewQuestion, textViewAnswer, textViewOption1,
            textViewOption2, textViewOption3, textViewOption4;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    ImageButton buttonBack, buttonFinish;
    // variables
    Intent get_intent, intent;
    String category, answer;
    int score, rightOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        // binding the views
        textViewCategory = (TextView) findViewById(R.id.textViewCategory);
        textViewQuestion = (TextView) findViewById(R.id.textViewQuestion);
        textViewAnswer = (TextView) findViewById(R.id.textViewAnswer);
        textViewAnswer.setText(""); // clear the text first
        textViewOption1 = (TextView) findViewById(R.id.textViewOption1);
        textViewOption2 = (TextView) findViewById(R.id.textViewOption2);
        textViewOption3 = (TextView) findViewById(R.id.textViewOption3);
        textViewOption4 = (TextView) findViewById(R.id.textViewOption4);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        buttonBack = (ImageButton) findViewById(R.id.imageButtonBack);
        buttonFinish = (ImageButton) findViewById(R.id.imageButtonFinish);

        get_intent = getIntent(); // get contents of CategoryActivity
        // assigning the contents
        category = get_intent.getStringExtra("CategoryName");
        score = get_intent.getIntExtra("score", 0);
        textViewQuestion.setText(get_intent.getStringExtra("question"));
        answer = get_intent.getStringExtra("answer");
        textViewOption1.setText(get_intent.getStringExtra("option1"));
        textViewOption2.setText(get_intent.getStringExtra("option2"));
        textViewOption3.setText(get_intent.getStringExtra("option3"));
        textViewOption4.setText(get_intent.getStringExtra("option4"));
        rightOption = get_intent.getIntExtra("rightOption", 0);

        // Anonymous Events
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(QuestionActivity.this, CategoryActivity.class); // creating the intent
                intent.putExtra("score", score); // send the score back
                finish(); // finalizing the QuestionActivity
                startActivity(intent); // navigating to the CategoryActivity
            }
        });
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // config the score layout
            }
        });
        // set the contents
        if(!TextUtils.isEmpty(category)) { // if variable is not null
            textViewCategory.setText(category);
        }
    }

    public void buttonClick(View view) {
        switch (view.getId()) {
            case R.id.radioButton1:
                // disable clicking other buttons
                radioButton2.setClickable(false);
                radioButton3.setClickable(false);
                radioButton4.setClickable(false);
                if(rightOption == 1)
                    score++; // increment the score
                textViewAnswer.setText(answer); // show the right answer
                break;
            case R.id.radioButton2:
                // disable clicking other buttons
                radioButton1.setClickable(false);
                radioButton3.setClickable(false);
                radioButton4.setClickable(false);
                if(rightOption == 2)
                    score++; // increment the score
                textViewAnswer.setText(answer); // show the right answer
                break;
            case R.id.radioButton3:
                // disable clicking other buttons
                radioButton2.setClickable(false);
                radioButton1.setClickable(false);
                radioButton4.setClickable(false);
                if(rightOption == 3)
                    score++; // increment the score
                textViewAnswer.setText(answer); // show the right answer
                break;
            case R.id.radioButton4:
                // disable clicking other buttons
                radioButton2.setClickable(false);
                radioButton3.setClickable(false);
                radioButton1.setClickable(false);
                if(rightOption == 4)
                    score++; // increment the score
                textViewAnswer.setText(answer); // show the right answer
                break;
        }
    }

    @Override
    public void onBackPressed() {
        // 'buttonBack' button can be used instead
    }
}