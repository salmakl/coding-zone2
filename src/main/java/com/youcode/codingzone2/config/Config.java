package com.youcode.codingzone2.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {

    private static String url = "jdbc:postgresql://localhost:5432/my_db";
    private static String user = "my_pg_user";
    private static String passwd = "hard_password";
    private static Connection connect;

    public static Connection getInstance(){
        if(connect == null){
            try {
<<<<<<< HEAD
                Class.forName("org.postgresql.Driver");
=======

>>>>>>> f5b82375b41fbd9c66ef90b2aca4002e21fb7c1f
                connect = DriverManager.getConnection(url, user, passwd);
                System.out.println("Connected to the PostgreSQL server successfully.");
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}