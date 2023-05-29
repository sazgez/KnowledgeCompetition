package com.devapp.competition;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class CategoryActivity extends AppCompatActivity {
    // views
    ListView listView;
    Button buttonScore;
    // variables
    Category[] categories;
    Adapter adapter;
    Intent intent;
    Dialog dialog;
    static int score, counter = 0; // 'counter' count the number of answered question
    static int[] answeredCorrect = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // -1: incorrect, 0: default, 1: correct

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        if(counter == 10) { // if all questions have been answered
            intent = new Intent(CategoryActivity.this, ResultActivity.class); // creating the intent
            finish(); // finalizing the CategoryActivity
            startActivity(intent); // navigating to the ResultActivity
        }
        // binding views
        listView = (ListView) findViewById(R.id.listView);
        buttonScore = (Button) findViewById(R.id.buttonScore);

        dialog = new Dialog(CategoryActivity.this, R.style.DialogCornerRadius); // creating the AlertDialog

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
        Question qArt = new Question(
                R.drawable.leodavinci,
                "Who does this masterpiece belong to?",
                "The name of the masterpiece is 'Head of a Woman' which belongs to Leonardo da Vinci.",
                "Vincent van Gogh",
                "Salvador Dali",
                "Leonardo da Vinci",
                "Pablo Picasso",
                3
                );
        Question qFootball = new Question(
                R.drawable.zidane,
                "In which tournament and year did this iconic incident take place?",
                "The incident that Zidane did a headbutt to Materazzi, took place in 2006 FIFA World Cup.",
                "2006 FIFA World Cup",
                "UEFA Euro 2008",
                "2010 FIFA World Cup",
                "UEFA Euro 2004",
                1
                );
        Question qHistory = new Question(
                "Which of the following is not among the leaders of the Soviet Union?",
                "Leon Trotsky was never the leader of the Soviet Union.",
                "Vladimir Lenin",
                "Leon Trotsky",
                "Mikhail Gorbachev",
                "Joseph Stalin",
                2
                );
        Question qIdeology = new Question(
                R.drawable.karlmarx,
                "Who is this person?",
                "It's Karl Marx. A German philosopher, economist, journalist and socialist revolutionary.",
                "Immanuel Kant",
                "Friedrich Nietzsche",
                "Karl Marx",
                "Friedrich Engels",
                3
                );
        Question qMusic = new Question(
                "Which of the following sings the music you are listening to?",
                "The singer is Flo Rida.",
                "Future",
                "Pitbull",
                "Usher",
                "Flo Rida",
                4,
                R.raw.florida
                );
        Question qScience = new Question(
                "What is the most abundant gas in the Earth's atmosphere?",
                "It's nitrogen (78%), followed by oxygen (21%), argon (0.93%), and carbon dioxide (0.03%).",
                "Nitrogen (N₂)",
                "Argon (Ar)",
                "Carbon dioxide (CO₂)",
                "Oxygen (O₂)",
                1
                );
        Question qGeo = new Question(
                R.drawable.finland,
                "Which country does the red place on the map represent?",
                "It's Finland.",
                "Denmark",
                "Finland",
                "Ireland",
                "Sweden",
                2
                );
        Question qBook = new Question(
                "Which of the following books was not written or contributed to by Friedrich Engels?",
                "The Antichrist belongs to Friedrich Nietzsche.",
                "The German Ideology",
                "Dialectics of Nature",
                "The Antichrist",
                "The Communist Manifesto",
                3
                );
        Question qCrypto = new Question(
                "When was Bitcoin officially released?",
                "On October 2008, the whitepaper of Bitcoin was published and on January 2009, Bitcoin was officially released.",
                "February 2009",
                "November 2008",
                "October 2008",
                "January 2009",
                4
                );

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
                if(answeredCorrect[position] == 0) { // if the question hasn't been answered yet
                    if(categories[position].question.image == 0 && categories[position].question.audio == 0) { // questions without images & audio
                        intent = new Intent(CategoryActivity.this, QuestionActivity.class); // creating the intent
                        intent.putExtra("position", position);
                        intent.putExtra("categoryName", categories[position].name);
                        intent.putExtra("question", categories[position].question.question);
                        intent.putExtra("answer", categories[position].question.answer);
                        intent.putExtra("option1", categories[position].question.option1);
                        intent.putExtra("option2", categories[position].question.option2);
                        intent.putExtra("option3", categories[position].question.option3);
                        intent.putExtra("option4", categories[position].question.option4);
                        intent.putExtra("rightOption", categories[position].question.rightOption);
                        startActivity(intent); // navigating to the QuestionActivity
                    } else if(categories[position].question.audio == 0) { // questions with images
                        intent = new Intent(CategoryActivity.this, ImageQuestionActivity.class); // creating the intent
                        intent.putExtra("position", position);
                        intent.putExtra("categoryName", categories[position].name);
                        intent.putExtra("image", categories[position].question.image);
                        intent.putExtra("question", categories[position].question.question);
                        intent.putExtra("answer", categories[position].question.answer);
                        intent.putExtra("option1", categories[position].question.option1);
                        intent.putExtra("option2", categories[position].question.option2);
                        intent.putExtra("option3", categories[position].question.option3);
                        intent.putExtra("option4", categories[position].question.option4);
                        intent.putExtra("rightOption", categories[position].question.rightOption);
                        startActivity(intent); // navigating to the ImageQuestionActivity
                    } else { // questions with audio
                        intent = new Intent(CategoryActivity.this, AudioQuestionActivity.class); // creating the intent
                        intent.putExtra("position", position);
                        intent.putExtra("categoryName", categories[position].name);
                        intent.putExtra("audio", categories[position].question.audio);
                        intent.putExtra("question", categories[position].question.question);
                        intent.putExtra("answer", categories[position].question.answer);
                        intent.putExtra("option1", categories[position].question.option1);
                        intent.putExtra("option2", categories[position].question.option2);
                        intent.putExtra("option3", categories[position].question.option3);
                        intent.putExtra("option4", categories[position].question.option4);
                        intent.putExtra("rightOption", categories[position].question.rightOption);
                        startActivity(intent); // navigating to the AudioQuestionActivity
                    }
                } else { // if the question has been answered before
                    Toast.makeText(CategoryActivity.this, "You've already answered the question.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void buttonClick(View view) {
        // set attributes of the dialog
        dialog.setContentView(R.layout.score); // set the layout to dialog
        TextView textViewScore = (TextView) dialog.findViewById(R.id.textViewScore); // binding the view
        textViewScore.setText("Your Score:   " + score); // updating the score
        dialog.setCancelable(true); // clicking anywhere on screen will dismiss the dialog
        dialog.show(); // showing the layout
    }

    @Override
    public void onBackPressed() {
        // preventing to work
    }
}