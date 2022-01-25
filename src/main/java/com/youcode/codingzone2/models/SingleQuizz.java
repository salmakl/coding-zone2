package com.youcode.codingzone2.models;

public class SingleQuizz {
    private String question;
    private int timeLimit;
    private String answer;
    private String options;

    public SingleQuizz(String question, int timeLimit, String answer, String options){
        this.question = question;
        this.timeLimit = timeLimit;
        this.answer = answer;
        this.options = options;
    };

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}
