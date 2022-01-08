package com.codingzone.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {

    private static String url = "jdbc:postgresql://localhost:5432/codingzone";
    private static String user = "postgres";
    private static String passwd = "2420";
    private static Connection connect;

    public static Connection getInstance(){
        if(connect == null){
            try {
                connect = DriverManager.getConnection(url, user, passwd);
                System.out.println("Connected to the PostgreSQL server successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}