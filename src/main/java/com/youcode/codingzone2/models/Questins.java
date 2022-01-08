package com.codingzone.models;

import java.sql.Timestamp;

public class Questins {
    private int id;
    private String question;
    private Timestamp limitTime;
    private int id_answer;
    private int id_category;

    public Questins(){}

    public Questins(int id, String question, Timestamp limitTime, int id_answer, int id_category){
        this.id = id;
        this.question = question;
        this.limitTime = limitTime;
        this.id_answer = id_answer;
        this.id_category = id_category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Timestamp getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(Timestamp limitTime) {
        this.limitTime = limitTime;
    }

    public int getId_answer() {
        return id_answer;
    }

    public void setId_answer(int id_answer) {
        this.id_answer = id_answer;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
}
