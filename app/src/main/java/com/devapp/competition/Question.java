package com.devapp.competition;

public class Question {
    String question, answer, option1, option2, option3, option4;
    int rightOption;

    public Question(String question, String answer, String option1, String option2, String option3, String option4, int rightOption) { // constructor
        this.question = question;
        this.answer = answer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.rightOption = rightOption;
    }

    public Question(){}; // empty constructor
}
