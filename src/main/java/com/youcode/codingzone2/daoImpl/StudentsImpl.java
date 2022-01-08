package com.youcode.codingzone2.daoImpl;

import com.youcode.codingzone2.dao.DAO;
import com.youcode.codingzone2.models.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentsImpl extends DAO<Students> {
    @Override
    public Students find(long id) {
        Students student =null;
        try {
            String Query=" SELECT * FROM users as p,students as s WHERE s.person_id=p.id and s.person_id ='"+ id +"' ";
            ResultSet resultSet = this.connect.createStatement().executeQuery(Query);

        }catch (SQLException e){
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Students create(Students obj) {
        return null;
    }

    @Override
    public Students update(Students obj) {
        return null;
    }

    @Override
    public void delete(Students obj) {

    }
}
