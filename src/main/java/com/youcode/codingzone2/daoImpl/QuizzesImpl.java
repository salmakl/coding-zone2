package com.youcode.codingzone2.daoImpl;

import com.youcode.codingzone2.config.Config;
import com.youcode.codingzone2.dao.DAO;
import com.youcode.codingzone2.helpers.CrudFunctions;
import com.youcode.codingzone2.models.Quizzes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class QuizzesImpl extends DAO<Quizzes> {
    @Override
    public Quizzes find(long id) {
        return null;
    }

    @Override
    public Quizzes create(Quizzes obj) {
        return null;
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
    public Quizzes createQuizz(Quizzes quizzes) {
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
}
