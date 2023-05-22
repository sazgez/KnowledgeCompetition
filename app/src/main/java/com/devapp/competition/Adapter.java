package com.devapp.competition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adapter extends ArrayAdapter<String> {
    String[] category;
    int[] image;
    Context context;
    LinearLayout linearLayout;
    ImageView imageView;
    TextView textView;

    public Adapter(String[] category, int[] image, Context context) { // constructor
        super(context, R.layout.category_item, category);
        this.category = category;
        this.image = image;
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
            imageView.setImageResource(image[position]);
            textView.setText(category[position]);
        }
        return view;
    }
}
