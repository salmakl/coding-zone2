package com.youcode.codingzone2.daoImpl;

import com.youcode.codingzone2.config.Config;
import com.youcode.codingzone2.dao.DAO;
import com.youcode.codingzone2.helpers.CrudFunctions;
import com.youcode.codingzone2.models.Quizzes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizzesImpl extends DAO<Quizzes> {
    @Override
    public Quizzes find(long id) {
        Quizzes quizz = new Quizzes();
        try {
            String Query="SELECT * FROM quizzes WHERE id = '"+id+"'";
            ResultSet rs = this.connect.createStatement().executeQuery(Query);

            while (rs.next()){
                quizz.setId(rs.getInt("id"));
                quizz.setName(rs.getString("quizz_name"));
                quizz.setDescription(rs.getString("quizz_description"));
                quizz.setId_category(rs.getInt("id_category"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return quizz;
    }


    @Override
    public Quizzes update(Quizzes obj) {
        return null;
    }

    @Override
    public void delete(Quizzes obj) {

    }

    @Override
    public List<Quizzes> getAllCategories() {
        return null;
    }

    @Override
    public Quizzes create(Quizzes quizzes) {
        try {
            PreparedStatement quizzesStatement = Config.getInstance().prepareStatement(CrudFunctions.insert("quizzes",4));
            quizzesStatement.setInt(1,quizzes.getId());
            quizzesStatement.setString(2,quizzes.getName());
            quizzesStatement.setString(3,quizzes.getDescription());
            quizzesStatement.setInt(4,quizzes.getId_category());
            quizzesStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizzes;
    }

    // select all quizzes
    public ArrayList<Quizzes> getAll(){
        ArrayList<Quizzes> quizzes = new ArrayList<>();

        try {
            String Query="SELECT * FROM quizzes";
            ResultSet rs = this.connect.createStatement().executeQuery(Query);

            while (rs.next()){
                Quizzes quizz = new Quizzes(rs.getInt("id"), rs.getString("quizz_name"), rs.getString("quizz_description"), rs.getInt("id_category"));
                quizzes.add(quizz);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return quizzes;
    }
}
