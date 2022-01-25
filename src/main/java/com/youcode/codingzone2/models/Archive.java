package com.youcode.codingzone2.models;

import java.sql.Timestamp;

public class Archive {
    private int id;
    private int quiz_id;
    private int student_id;
    private float score;
    private Timestamp submitted_at;

    public Archive() {
    }

    public Archive(int quiz_id, int student_id, float score, Timestamp submitted_at) {
        this.quiz_id = quiz_id;
        this.student_id = student_id;
        this.score = score;
        this.submitted_at = submitted_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public int getStudentId(){
        return student_id;
    }

    public void setStudentId(int student_id){
        this.student_id = student_id;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Timestamp getSubmitted_at() {
        return submitted_at;
    }

    public void setSubmitted_at(Timestamp submitted_at) {
        this.submitted_at = submitted_at;
    }
}
