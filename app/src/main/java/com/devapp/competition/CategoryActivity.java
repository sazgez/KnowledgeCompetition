package com.devapp.competition;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class CategoryActivity extends AppCompatActivity {
    // views
    ListView listView;
    Button buttonScore;
    // variables
    Category[] categories;
    Adapter adapter;
    Intent intent, get_intent;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    int score = 0;
    static int[] answeredCorrect = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // -1: incorrect, 0: default, 1: correct

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // binding views
        listView = (ListView) findViewById(R.id.listView);
        buttonScore = (Button) findViewById(R.id.buttonScore);

        dialog = new AlertDialog.Builder(CategoryActivity.this); // creating the AlertDialog
        inflater = LayoutInflater.from(CategoryActivity.this); // set the inflater
        get_intent = getIntent(); // get contents of QuestionActivity

        // creating questions
        Question qTech = new Question(
                "When was Java initially released?",
                "Java was initially released on January 23, 1996, by Sun Microsystems.",
                "December 30, 1995",
                "January 23, 1996",
                "February 16, 1997",
                "May 1, 1997",
                2
                );
        Question qArt = new Question();
        Question qFootball = new Question();
        Question qHistory = new Question();
        Question qIdeology = new Question();
        Question qMusic = new Question();
        Question qScience = new Question();
        Question qGeo = new Question();
        Question qBook = new Question();
        Question qCrypto = new Question();

        // creating categories
        Category technology = new Category("Technology", R.drawable.technology, qTech);
        Category art = new Category("Art", R.drawable.art, qArt);
        Category football = new Category("Football", R.drawable.football, qFootball);
        Category history = new Category("History", R.drawable.history, qHistory);
        Category ideology = new Category("Ideology", R.drawable.ideology, qIdeology);
        Category music = new Category("Music", R.drawable.music, qMusic);
        Category science = new Category("Science", R.drawable.science, qScience);
        Category geography = new Category("Geography", R.drawable.geography, qGeo);
        Category book = new Category("Book", R.drawable.book, qBook);
        Category crypto = new Category("Crypto-finance", R.drawable.crypto, qCrypto);

        // storing each category in our array called 'Category'
        categories = new Category[]{technology, art, football, history, ideology,
                                    music, science, geography, book, crypto};

        adapter = new Adapter(categories, CategoryActivity.this); // creating the adapter

        listView.setAdapter(adapter); // set the adapter to list

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(CategoryActivity.this, QuestionActivity.class); // creating the intent
                intent.putExtra("position", position);
                intent.putExtra("categoryName", categories[position].name);
                intent.putExtra("score", score);
                intent.putExtra("question", categories[position].question.question);
                intent.putExtra("answer", categories[position].question.answer);
                intent.putExtra("option1", categories[position].question.option1);
                intent.putExtra("option2", categories[position].question.option2);
                intent.putExtra("option3", categories[position].question.option3);
                intent.putExtra("option4", categories[position].question.option4);
                intent.putExtra("rightOption", categories[position].question.rightOption);
                startActivity(intent); // navigating to the QuestionActivity
            }
        });
    }

    public void buttonClick(View view) {
        view = inflater.inflate(R.layout.score, null); // bound the layout to be showed
        score = get_intent.getIntExtra("score", 0); // update the value of score
        // binding views
        TextView textViewScore = (TextView) view.findViewById(R.id.textViewScore);
        // setting
        dialog.setView(view); // set the view into the AlertDialog
        dialog.setCancelable(true); // clicking anywhere on screen will dismiss the dialog
        textViewScore.setText("Your Score: " + score); // updating the score
        dialog.show(); // showing the layout
    }

    @Override
    public void onBackPressed() {
        // preventing to work
    }
}