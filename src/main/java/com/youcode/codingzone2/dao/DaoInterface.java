package com.youcode.codingzone2.dao;
import java.sql.Connection;
import java.util.List;

public interface DaoInterface <T> {
    String delete(String id);

    List<T> findAll();

    T findById(String id);

    T insert(T object);

    String update(T object);

}







