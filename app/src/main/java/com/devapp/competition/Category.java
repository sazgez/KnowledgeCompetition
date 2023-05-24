package com.devapp.competition;

public class Category {
    String name;
    int image;
    Question question;

    public Category(String name, int image, Question question) { // constructor
        this.name = name;
        this.image = image;
        this.question = question;
    }
}
