package com.youcode.codingzone2.daoImpl;

import com.youcode.codingzone2.dao.DAO;
import com.youcode.codingzone2.models.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersImpl extends DAO<Users>{

    public ArrayList<Users> getAll(){

        ArrayList<Users> students = new ArrayList<>();

        try {
            String Query="SELECT s.id, u.first_name, u.last_name, u.email from users u INNER JOIN students s ON u.id = s.id_user";
            ResultSet rs = this.connect.createStatement().executeQuery(Query);

            while (rs.next()){
                Users student = new Users(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"));
                students.add(student);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Users find(long id) {
        return null;
    }

    @Override
    public Users create(Users obj) {
        return null;
    }

    @Override
    public Users update(Users obj) {
        return null;
    }

    @Override
    public void delete(Users obj) {

    }

    @Override
    public List<Users> getAllCategories() {
        return null;
    }



}
