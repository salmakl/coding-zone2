package com.youcode.codingzone2.daoImpl;

import com.youcode.codingzone2.config.Config;
import com.youcode.codingzone2.dao.DaoInterface;
import com.youcode.codingzone2.helpers.CrudFunctions;
import com.youcode.codingzone2.models.Questins;
import com.youcode.codingzone2.models.QuizzQuestions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizzQuestionImpl implements DaoInterface<Questins> {


    @Override
    public String delete(String id) {
        return null;
    }

    public List<Questins> findAll() {
        ArrayList<Questins> questions = new ArrayList<>();
        try {
            ResultSet resultSet = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(CrudFunctions.getAll("questions"));
            questions.clear();
            while (resultSet.next()){
                Questins questins = new Questins(resultSet.getInt("id"),resultSet.getString("question"),resultSet.getInt("time_limit"),resultSet.getInt("id_answer"),resultSet.getInt("id_category"));
                questions.add(questins);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }
    public QuizzQuestions insertQuizzQuestion(QuizzQuestions quizzQuestions) {
        try {
            PreparedStatement quizzQuestion = Config.getInstance().prepareStatement(CrudFunctions.insert("quizz_questions",2));
            quizzQuestion.setInt(1,quizzQuestions.getId_quizz());
            quizzQuestion.setInt(2,quizzQuestions.getId_question());
            quizzQuestion.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizzQuestions;
    }

    @Override
    public Questins findById(String id) {
        return null;
    }

    @Override
    public Questins insert(Questins object) {
        return null;
    }

    @Override
    public String update(Questins object) {
        return null;
    }
}
