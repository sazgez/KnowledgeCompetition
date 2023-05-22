package com.devapp.competition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetailsActivity extends AppCompatActivity {

    Button buttonReady;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // binding views
        buttonReady = (Button) findViewById(R.id.buttonReady);
    }

    public void buttonClick(View view) {
        intent = new Intent(DetailsActivity.this, CategoryActivity.class); // creating the intent
        finish(); // finalizing the DetailsActivity
        startActivity(intent); // navigating to the CategoryActivity
    }
}