package com.codingzone.models;

public class Answers {
    private int answer_id;
    private String answer;
    private int id_category;

    public Answers() {}

    public Answers(int answer_id, String answer, int id_category) {
        this.answer_id = answer_id;
        this.answer = answer;
        this.id_category = id_category;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
}
