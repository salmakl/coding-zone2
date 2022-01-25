package com.youcode.codingzone2.daoImpl;

import com.youcode.codingzone2.dao.DAO;
import com.youcode.codingzone2.models.SingleQuizz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SingleQuizzImpl extends DAO<SingleQuizz> {

    public ArrayList<SingleQuizz> getAll(int id) {
        ArrayList<SingleQuizz> quiz = new ArrayList<>();

        try {
            String Query="SELECT questions.question, a.answer, questions.time_limit," +
                    " (SELECT JSON_AGG(op.answer) FROM answers op, questions_opts" +
                    " WHERE questions_opts.id_opt = op.id AND questions_opts.id_question = questions.id) AS options" +
                    " FROM questions" +
                    " JOIN answers a ON a.id = questions.id_answer" +
                    " JOIN questions_opts ON questions_opts.id_question = questions.id" +
                    " JOIN quizz_questions ON quizz_questions.id_question = questions.id AND quizz_questions.id_quizz = " + id + " " +
                    " GROUP BY questions.id, a.id";
            ResultSet rs = this.connect.createStatement().executeQuery(Query);

            while (rs.next()){
                SingleQuizz question = new SingleQuizz(rs.getString("question"), rs.getInt("time_limit"), rs.getString("answer"), rs.getString("options"));
                quiz.add(question);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return quiz;
    }

    @Override
    public SingleQuizz find(long id) {
        return null;
    }

    @Override
    public SingleQuizz create(SingleQuizz obj) {
        return null;
    }

    @Override
    public SingleQuizz update(SingleQuizz obj) {
        return null;
    }

    @Override
    public void delete(SingleQuizz obj) {

    }

    @Override
    public List<SingleQuizz> getAllCategories() {
        return null;
    }

    @Override
    public List<SingleQuizz> getAll() {
        return null;
    }
}
