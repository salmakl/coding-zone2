package com.youcode.codingzone2.dao;


import com.youcode.codingzone2.config.Config;

import java.sql.Connection;

 abstract class DAO<T> {

    public Connection connect = Config.getInstance();

    public abstract T find(long id);
    public abstract T create(T obj);
    public abstract T update(T obj);
    public abstract void delete(T obj);

}