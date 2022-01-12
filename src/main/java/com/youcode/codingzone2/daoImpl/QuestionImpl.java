package com.youcode.codingzone2.daoImpl;

import com.youcode.codingzone2.config.Config;
import com.youcode.codingzone2.dao.DAO;
import com.youcode.codingzone2.models.Questins;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionImpl extends DAO<Questins> {

    Connection connection= Config.getInstance();

    @Override
    public Questins find(long id) {
        return null;
    }

    @Override
    public Questins create(Questins obj) {
        PreparedStatement ps = null;

        try{
            String query="INSERT INTO questions(question,limitTime,id_answer,id_category) values (?,?,?,?) ";
            ps=connection.prepareStatement(query);
            ps.setString(1,obj.getQuestion());
            ps.setInt(2,obj.getLimitTime());
            ps.setInt(3,obj.getId_answer());
            ps.setInt(4,obj.getId_category());

            ps.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Questins update(Questins obj) {
        return null;
    }

    @Override
    public void delete(Questins obj) {

    }

    public ArrayList<Questins> getAll(){
        ArrayList<Questins> questions= new ArrayList<>();

        try{
            String Query="SELECT * FROM questions q, answers a Where a.id=q.id_answer";
            ResultSet Rs = this.connection.createStatement().executeQuery(Query);
            while (Rs.next()){
                Questins question=new Questins(
                        Rs.getInt("id"),
                        Rs.getString("question"),
                        Rs.getInt("time_limit"),
                        Rs.getInt("id_answer"),
                        Rs.getInt("id_category"));
                questions.add(question);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }


    return questions;
    }
}
