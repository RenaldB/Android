package com.cesi.topqizz.model;

import java.util.List;

public class Question {
    private String mQuestion;
    private List<String> mChoiceList;
    private int mAnswerIndex;
    private String mAnswerExplain;

    public Question(String question, List<String> choiceList, int answerIndex, String answerExplain) {
        mQuestion = question;
        mChoiceList = choiceList;
        mAnswerIndex = answerIndex;
        mAnswerExplain = answerExplain;
    }

    public String getAnswerExplain() {
        return mAnswerExplain;
    }

    public void setAnswerExplain(String answerExplain) {
        mAnswerExplain = answerExplain;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public List<String> getChoiceList() {
        return mChoiceList;
    }

    public void setChoiceList(List<String> choiceList) {
        mChoiceList = choiceList;
    }

    public int getAnswerIndex() {
        return mAnswerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        mAnswerIndex = answerIndex;
    }

}
