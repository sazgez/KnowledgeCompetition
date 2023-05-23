package com.devapp.competition;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
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

    ListView listView;
    Button buttonScore;
    String[] category = {"Technology", "Art", "Football", "History", "Ideology",
                        "Music", "Science", "Geography", "Book", "Crypto-finance"};
    int[] image = {R.drawable.technology, R.drawable.art, R.drawable.football, R.drawable.history,
                R.drawable.ideology, R.drawable.music, R.drawable.science, R.drawable.geography,
                R.drawable.book, R.drawable.crypto};
    Adapter adapter;
    Intent intent;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // binding view
        listView = (ListView) findViewById(R.id.listView);
        buttonScore = (Button) findViewById(R.id.buttonScore);
        adapter = new Adapter(category, image, CategoryActivity.this); // creating the adapter
        dialog = new AlertDialog.Builder(CategoryActivity.this); // creating the AlertDialog
        inflater = LayoutInflater.from(CategoryActivity.this); // set the inflater
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
        view = inflater.inflate(R.layout.score, null); // bound the layout to be showed
        dialog.setView(view); // set the view into the AlertDialog
        dialog.setCancelable(true); // clicking anywhere on screen will dismiss the dialog
        dialog.show(); // showing the layout
    }
}