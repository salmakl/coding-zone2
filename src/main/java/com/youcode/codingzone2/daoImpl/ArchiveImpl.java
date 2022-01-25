package com.youcode.codingzone2.daoImpl;

import com.youcode.codingzone2.dao.DAO;
import com.youcode.codingzone2.models.Archive;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ArchiveImpl extends DAO<Archive> {

    @Override
    public Archive find(long id) {
        return null;
    }

    @Override
    public Archive create(Archive archive) {
        PreparedStatement ps = null;
        try {
            String query="INSERT INTO archives (id_quizz, id_student, score, submitted_at) VALUES (?, ?, ?, ?)";
            ps=connect.prepareStatement(query);
            ps.setInt(1, archive.getQuiz_id());
            ps.setInt(2, archive.getStudentId());
            ps.setDouble(3, archive.getScore());
            ps.setTimestamp(4, archive.getSubmitted_at());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Archive update(Archive obj) {
        return null;
    }

    @Override
    public void delete(Archive obj) {

    }

    @Override
    public List<Archive> getAllCategories() {
        return null;
    }

    @Override
    public List<Archive> getAll() {
        return null;
    }
}
