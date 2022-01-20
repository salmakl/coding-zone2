package com.youcode.codingzone2.models;

public class QuizzQuestions {
    private int id_quizz;
    private int id_question;
    public QuizzQuestions (int id_quizz,int id_question){
        this.id_quizz = id_quizz;
        this.id_question = id_question;
    }

    public int getId_quizz() {
        return id_quizz;
    }

    public void setId_quizz(int id_quizz) {
        this.id_quizz = id_quizz;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }
}
