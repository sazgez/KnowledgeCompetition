package com.devapp.competition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonDetails, buttonStart;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // binding views
        buttonDetails = (Button) findViewById(R.id.buttonDetails);
        buttonStart = (Button) findViewById(R.id.buttonStart);
    }

    public void buttonClick(View view) {
        switch (view.getId()) {
            case R.id.buttonDetails:
                intent = new Intent(MainActivity.this, DetailsActivity.class); // creating the intent
                finish(); // finalizing the MainActivity
                startActivity(intent); // navigating to the DetailsActivity
                break;
            case R.id.buttonStart:
                intent = new Intent(MainActivity.this, CategoryActivity.class); // creating the intent
                finish(); // finalizing the MainActivity
                startActivity(intent); // navigating to the CategoryActivity
                break;
        }
    }
}