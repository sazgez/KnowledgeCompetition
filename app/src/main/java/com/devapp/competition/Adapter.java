package com.devapp.competition;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adapter extends ArrayAdapter<Category> {
    // views
    LinearLayout linearLayout;
    ImageView imageView;
    TextView textView;
    // variables
    Category[] categories;
    Context context;

    public Adapter(Category[] categories, Context context) { // constructor
        super(context, R.layout.category_item, categories);
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_item, null);
        if(view != null) {
            // binding views
            linearLayout = (LinearLayout) view.findViewById(R.id.linearLayoutCategory);
            imageView = (ImageView) view.findViewById(R.id.imageViewCategory);
            textView = (TextView) view.findViewById(R.id.textViewCategory);

            // set views
            imageView.setImageResource(categories[position].image);
            textView.setText(categories[position].name);
            if(CategoryActivity.answeredCorrect[position] == 1) // if correctly answered,
                linearLayout.setBackgroundColor(Color.GREEN); // change the background as green.
            else if(CategoryActivity.answeredCorrect[position] == -1) // if incorrectly answered,
                linearLayout.setBackgroundColor(Color.RED); // change the background as red.
        }
        return view;
    }
}
