package com.youcode.codingzone2.daoImpl;

import com.youcode.codingzone2.config.Config;
import com.youcode.codingzone2.dao.DAO;
import com.youcode.codingzone2.dao.DaoInterface;
import com.youcode.codingzone2.helpers.CrudFunctions;
import com.youcode.codingzone2.models.Categories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements DaoInterface<Categories> {
    Connection connection = Config.getInstance();
    Categories categories;
    @Override
    public String delete(String id) {
        return null;
    }
    @Override
    public List<Categories> findAll() {
        ArrayList<Categories> categories = new ArrayList<>();
        try {
            ResultSet resultSet = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(CrudFunctions.getAll("categories"));
            categories.clear();
            while (resultSet.next()){
                Categories category = new Categories(resultSet.getInt("id"),resultSet.getString("category"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
    @Override
    public Categories findById(String id) {
        try {

            ResultSet result = Config.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(
                    CrudFunctions.getById("categories",id));
            if (result.first()) {
                categories = new Categories(result.getInt("id"), result.getString("competence_name"));
            }
            return categories;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public Categories insert(Categories object) {
        return null;
    }

    @Override
    public String update(Categories object) {
        return null;
    }
}
