package com.youcode.codingzone2.daoImpl;

import com.youcode.codingzone2.config.Config;
import com.youcode.codingzone2.dao.DAO;
import com.youcode.codingzone2.models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class StudentsImpl extends DAO<Students> {

    Connection connection= Config.getInstance();
    @Override
    public Students find(long id) {
        Students student =null;
        try {
            String Query=" SELECT * FROM users as p,students as s WHERE s.person_id=p.id and s.person_id ='"+ id +"' ";
            ResultSet resultSet = this.connection.createStatement().executeQuery(Query);
            while (resultSet.next()){
                student = new Students();
                student.setId(resultSet.getInt("id"));
                student.setFirstname(resultSet.getString("first_name"));
                student.setLastname(resultSet.getString("last_name"));
                student.setEmail(resultSet.getString("email"));
                ((Students) student).setIdStudent(resultSet.getLong("id_student"));
                ((Students) student).setClasse(resultSet.getString("classe"));
                ((Students) student).setPromotion(resultSet.getInt("promotion"));
            }

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


    @Override
    public List<Students> getAllCategories() {
        return null;
    }



    @Override
    public Students createQuizz(Students obj) {
        return null;
    }

    public ArrayList<Students> getAll(){
        ArrayList<Students> students = new ArrayList<>();

        try {
            String Query=" SELECT * FROM users u,students  s WHERE s.id_user=u.id ";
            ResultSet resultSet = this.connection.createStatement().executeQuery(Query);
            while (resultSet.next()){
                Users student = new Students();
                student.setId(resultSet.getInt("id"));
                student.setFirstname(resultSet.getString("first_name"));
                student.setLastname(resultSet.getString("last_name"));
                student.setEmail(resultSet.getString("email"));
               //((Students) student).setIdStudent(resultSet.getLong("id_student"));
                ((Students) student).setClasse(resultSet.getString("classe"));
                ((Students) student).setPromotion(resultSet.getInt("promo"));

                students.add((Students) student);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return students;
    }
    //filter

    public ArrayList<Students> filter(String search){

        ArrayList<Students> students = new ArrayList<>();
        PreparedStatement Ps = null;
        ResultSet resultSet = null;
        try {
            String Query="SELECT * FROM users u,students s WHERE s.id_user=u.id AND u.first_name LIKE '%"+search+"%'  OR u.last_name LIKE '%"+search+"%'OR s.classe LIKE '%"+search+"%'";
            Ps=connection.prepareStatement(Query);
            resultSet= Ps.executeQuery();
            while (resultSet.next()){

                Users student = new Students();
                student.setId(resultSet.getInt("id"));
                student.setFirstname(resultSet.getString("first_name"));
                student.setLastname(resultSet.getString("last_name"));
                student.setEmail(resultSet.getString("email"));
                //((Students) student).setIdStudent(resultSet.getLong("id_student"));
                ((Students) student).setClasse(resultSet.getString("classe"));
                ((Students) student).setPromotion(resultSet.getInt("promo"));

                students.add((Students) student);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return students;
    }
}
