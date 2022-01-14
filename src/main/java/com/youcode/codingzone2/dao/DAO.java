package com.youcode.codingzone2.dao;


import com.youcode.codingzone2.config.Config;
import com.youcode.codingzone2.models.Categories;

import java.sql.Connection;
import java.util.List;

public abstract class DAO<T> {

    public Connection connect = Config.getInstance();

    public abstract T find(long id);
    public abstract T create(T obj);
    public abstract T update(T obj);
    public abstract void delete(T obj);
    public abstract List<T> getAllCategories();
    public abstract T createQuizz(T obj);
}