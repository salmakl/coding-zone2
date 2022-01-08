package com.codingzone.models;

public class Students extends Users {

    private Long idStudent;
    private String classe;
    private int promotion;

    public Students() {
    }

    public Students(int id, String firstname, String lastname, String email, Long idStudent, String classe, int promotion) {
        super();
        this.idStudent = idStudent;
        this.classe = classe;
        this.promotion = promotion;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }
}
