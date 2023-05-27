package com.devapp.competition;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
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
    AlertDialog.Builder dialog;
    String answer;
    int rightOption, position;

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

        dialog = new AlertDialog.Builder(QuestionActivity.this); // creating the dialog

        get_intent = getIntent(); // get contents of CategoryActivity
        // assigning the contents
        position = get_intent.getIntExtra("position", -1);
        textViewCategory.setText(get_intent.getStringExtra("categoryName"));
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
                finish(); // finalizing the QuestionActivity
                startActivity(intent); // navigating to the CategoryActivity
            }
        });
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set
                dialog.setIcon(R.drawable.ic_exit);
                dialog.setTitle("GIVING UP?");
                dialog.setMessage("Are you sure you want to finish the competition?");
                dialog.setCancelable(false); // prevent clicking anywhere to go back
                dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); // return to the competition
                    }
                });
                dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // creating the intent
                        Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                        finish(); // finalizing the QuestionActivity
                        startActivity(intent); // navigating to the ResultActivity
                    }
                });
                dialog.show(); // showing the layout
            }
        });
    }

    public void buttonClick(View view) {
        switch (view.getId()) {
            case R.id.radioButton1:
                // disable clicking other buttons
                radioButton2.setClickable(false);
                radioButton3.setClickable(false);
                radioButton4.setClickable(false);
                if(rightOption == 1) {
                    CategoryActivity.score++; // increment the score
                    CategoryActivity.answeredCorrect[position] = 1; // question have been answered correctly
                } else {
                    CategoryActivity.answeredCorrect[position] = -1; // question have been answered incorrectly
                }
                textViewAnswer.setText(answer); // show the right answer
                CategoryActivity.counter++; // increment the counter
                break;
            case R.id.radioButton2:
                // disable clicking other buttons
                radioButton1.setClickable(false);
                radioButton3.setClickable(false);
                radioButton4.setClickable(false);
                if(rightOption == 2) {
                    CategoryActivity.score++; // increment the score
                    CategoryActivity.answeredCorrect[position] = 1; // question have been answered correctly
                } else {
                    CategoryActivity.answeredCorrect[position] = -1; // question have been answered incorrectly
                }
                textViewAnswer.setText(answer); // show the right answer
                CategoryActivity.counter++; // increment the counter
                break;
            case R.id.radioButton3:
                // disable clicking other buttons
                radioButton2.setClickable(false);
                radioButton1.setClickable(false);
                radioButton4.setClickable(false);
                if(rightOption == 3) {
                    CategoryActivity.score++; // increment the score
                    CategoryActivity.answeredCorrect[position] = 1; // question have been answered correctly
                } else {
                    CategoryActivity.answeredCorrect[position] = -1; // question have been answered incorrectly
                }
                textViewAnswer.setText(answer); // show the right answer
                CategoryActivity.counter++; // increment the counter
                break;
            case R.id.radioButton4:
                // disable clicking other buttons
                radioButton2.setClickable(false);
                radioButton3.setClickable(false);
                radioButton1.setClickable(false);
                if(rightOption == 4) {
                    CategoryActivity.score++; // increment the score
                    CategoryActivity.answeredCorrect[position] = 1; // question have been answered correctly
                } else {
                    CategoryActivity.answeredCorrect[position] = -1; // question have been answered incorrectly
                }
                textViewAnswer.setText(answer); // show the right answer
                CategoryActivity.counter++; // increment the counter
                break;
        }
    }

    @Override
    public void onBackPressed() {
        // 'buttonBack' button can be used instead
    }
}