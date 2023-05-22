package com.devapp.competition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class CategoryActivity extends AppCompatActivity {

    ListView listView;
    Button buttonScore;
    String[] category = {"Technology", "Art", "Football", "History", "Ideology",
                        "Music", "Science", "Geography", "Book", "Crypto-finance"};
    int[] image = {R.drawable.technology, R.drawable.art, R.drawable.football, R.drawable.history,
                R.drawable.ideology, R.drawable.music, R.drawable.science, R.drawable.geography,
                R.drawable.book, R.drawable.crypto};
    Adapter adapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // binding view
        listView = (ListView) findViewById(R.id.listView);
        buttonScore = (Button) findViewById(R.id.buttonScore);
        adapter = new Adapter(category, image, CategoryActivity.this); // creating the adapter
        listView.setAdapter(adapter); // set the adapter to list

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //intent = new Intent(CategoryActivity.this, ???); // creating the intent
                // intent putExtra
                //startActivity(intent); // navigating to the ???
            }
        });
    }

    public void buttonClick(View view) {
        // Score button click
    }
}