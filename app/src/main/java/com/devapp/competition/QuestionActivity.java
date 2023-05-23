package com.devapp.competition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {

    TextView textViewCategory, textViewQuestion;
    ImageButton buttonBack, buttonFinish;
    Intent get_intent, intent;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        // binding the views
        textViewCategory = (TextView) findViewById(R.id.textViewCategory);
        textViewQuestion = (TextView) findViewById(R.id.textViewQuestion);
        buttonBack = (ImageButton) findViewById(R.id.imageButtonBack);
        buttonFinish = (ImageButton) findViewById(R.id.imageButtonFinish);

        get_intent = getIntent(); // get contents of CategoryActivity
        // assigning the contents
        category = get_intent.getStringExtra("category");
        // Anonymous Events
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(QuestionActivity.this, CategoryActivity.class); // creating the intent
                startActivity(intent); // navigating to the CategoryActivity
            }
        });
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // config the score layout
            }
        });

        if(!TextUtils.isEmpty(category)) { // if variable is not null
            textViewCategory.setText(category);
        }
    }

    @Override
    public void onBackPressed() {
        // 'buttonBack' button can be used instead
    }
}