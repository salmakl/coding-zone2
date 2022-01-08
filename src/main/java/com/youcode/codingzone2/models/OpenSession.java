package com.codingzone.models;

public class OpenSession {

    private String sessionId;
    private int studentId;
    private int quizId;

    public OpenSession() {
    }

    public OpenSession(String sessionId, int studentId, int quizId) {
        this.sessionId = sessionId;
        this.studentId = studentId;
        this.quizId = quizId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }
}
