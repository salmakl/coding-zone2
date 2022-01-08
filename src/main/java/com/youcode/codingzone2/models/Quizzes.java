package com.codingzone.models;

public class Quizzes {
    private int id;
    private String name;
    private String description;
    private int id_category;

    public Quizzes() {
    }

    public Quizzes(int id, String name, String description, int id_category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.id_category = id_category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
}

