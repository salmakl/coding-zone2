package com.youcode.codingzone2.daoImpl;

import com.youcode.codingzone2.config.Config;
import com.youcode.codingzone2.dao.DAO;
import com.youcode.codingzone2.models.Staffs;
import com.youcode.codingzone2.models.Users;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class StaffsImpl extends DAO<Staffs> {


    @Override
    public Staffs find(long id) {
        return null;
    }

    @Override
    public Staffs create(Staffs obj) {
        return null;
    }

    @Override
    public Staffs update(Staffs obj) {
        return null;
    }

    @Override
    public void delete(Staffs obj) {}

    @Override
    public List<Staffs> getAllCategories() {
        return null;
    }

    @Override
    public List<Staffs> getAll() {
        return null;
    }


    public Users login(String email, String password) throws Exception {
        Users staff = new Staffs();

        String query = "SELECT * FROM users u,stuffs s WHERE u.id=s.id_user AND email= '"+email+"' AND acc_password='"+password+"'";

        Connection connection= Config.getInstance();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()){
            staff.setId((int)resultSet.getLong("id"));
            staff.setEmail(resultSet.getString("email"));
            ((Staffs) staff).setPassword(resultSet.getString("acc_password"));
            return staff;
        }
        return null;
    }
}
