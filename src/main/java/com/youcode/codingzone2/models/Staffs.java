package com.codingzone.models;

public class Staffs extends Users {

    private String staffId;
    private String password;

    public Staffs() {
    }

    public Staffs(int id, String firstname, String lastname, String email, String staffId, String password) {
        super();
        this.staffId = staffId;
        this.password = password;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
