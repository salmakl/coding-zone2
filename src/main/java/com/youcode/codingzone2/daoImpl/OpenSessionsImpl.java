package com.youcode.codingzone2.daoImpl;

import com.youcode.codingzone2.dao.DAO;
import com.youcode.codingzone2.models.OpenSession;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OpenSessionsImpl extends DAO<OpenSession> {
    @Override
    public OpenSession find(long id) {
        return null;
    }

    @Override
    public OpenSession create(OpenSession session) {
        PreparedStatement ps = null;

        try {
            String query="INSERT INTO open_sessions (id, id_quizz, id_student)VALUES (?, ?, ?)";
            ps=connect.prepareStatement(query);
            ps.setString(1, session.getSessionId());
            ps.setInt(2, session.getQuizId());
            ps.setInt(3, session.getStudentId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public OpenSession update(OpenSession obj) {
        return null;
    }

    @Override
    public void delete(OpenSession obj) {

    }

    @Override
    public List<OpenSession> getAllCategories() {
        return null;
    }

    @Override
    public List<OpenSession> getAll() {
        return null;
    }

    public OpenSession findById(String id){
        OpenSession session = new OpenSession();
        try {
            String Query="SELECT * FROM open_sessions WHERE id = '"+ id +"'";
            ResultSet rs = this.connect.createStatement().executeQuery(Query);
            while (rs.next()){
                session.setSessionId(rs.getString("id"));
                session.setQuizId(rs.getInt("id_quizz"));
                session.setStudentId(rs.getInt("id_student"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return session;
    }

}
