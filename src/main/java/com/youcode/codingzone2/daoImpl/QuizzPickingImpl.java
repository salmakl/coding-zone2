package com.youcode.codingzone2.daoImpl;

import com.youcode.codingzone2.config.Config;
import com.youcode.codingzone2.dao.DaoInterface;
import com.youcode.codingzone2.helpers.CrudFunctions;
import com.youcode.codingzone2.models.Categories;
import com.youcode.codingzone2.models.Quizzes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizzPickingImpl implements DaoInterface<Quizzes> {
    private Connection connect;

    @Override
    public String delete(String id) {
        return null;
    }

    @Override
    public List findAll() {
        ArrayList<Quizzes> quizzes = new ArrayList<>();
        try {
            ResultSet resultSet = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(CrudFunctions.getAll("quizzes"));
            quizzes.clear();
            while (resultSet.next()){
                Quizzes quizz = new Quizzes(resultSet.getInt("id"),resultSet.getString("quizz_name"),resultSet.getString("quizz_description"),resultSet.getInt("id_category"));
                quizzes.add(quizz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizzes;
    }

    @Override
    public Quizzes findById(String id) {
        return null;
    }

    @Override
    public Quizzes insert(Quizzes object) {
        return null;
    }

    @Override
    public String update(Quizzes object) {
        return null;
    }

}
