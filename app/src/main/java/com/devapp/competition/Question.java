package com.devapp.competition;

public class Question {
    String question, answer, option1, option2, option3, option4;
    int rightOption, image = 0, audio = 0;

    public Question(String question, String answer, String option1, String option2, String option3, String option4, int rightOption) { // constructor without image
        this.question = question;
        this.answer = answer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.rightOption = rightOption;
    }

    public Question(int image, String question, String answer, String option1, String option2, String option3, String option4, int rightOption) { // constructor with image
        this.image = image;
        this.question = question;
        this.answer = answer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.rightOption = rightOption;
    }

    public Question(String question, String answer, String option1, String option2, String option3, String option4, int rightOption, int audio) { // constructor with audio
        this.question = question;
        this.answer = answer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.rightOption = rightOption;
        this.audio = audio;
    }

    public Question(){}; // empty constructor
}
