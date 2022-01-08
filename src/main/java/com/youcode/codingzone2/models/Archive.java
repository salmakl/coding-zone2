package com.codingzone.models;

import java.sql.Timestamp;

public class Archive {
    private int id;
    private int quiz_id;
    private float score;
    private Timestamp submitted_at;

    public Archive() {
    }

    public Archive(int quiz_id, float score, Timestamp submitted_at) {
        this.quiz_id = quiz_id;
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
