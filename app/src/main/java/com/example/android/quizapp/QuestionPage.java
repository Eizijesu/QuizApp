package com.example.android.quizapp;

/*
    this hold all the questions related to this quiz
     */
public class QuestionPage {

    private int imageID;

    private String questionTxt;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    private String correctAns;
    private boolean takenAlready;

    public QuestionPage(int imageID, String questionTxt, String optionA, String optionB, String optionC, String optionD, String correctAns) {
        this.imageID = imageID;
        this.questionTxt = questionTxt;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAns = correctAns;
        this.takenAlready = false;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getQuestionTxt() {
        return questionTxt;
    }

    public void setQuestionTxt(String questionTxt) {
        this.questionTxt = questionTxt;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public boolean isTakenAlready() {
        return takenAlready;
    }

    public void setTakenAlready(boolean takenAlready) {
        this.takenAlready = takenAlready;

    }

    public boolean isCorrectAns(String selectedAnswer){
        return  (selectedAnswer.equals(correctAns));
    }

    @Override
    public  String toString() {
        return questionTxt;
    }
}


