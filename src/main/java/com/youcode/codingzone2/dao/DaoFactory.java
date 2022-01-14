package com.youcode.codingzone2.dao;

import com.youcode.codingzone2.daoImpl.CategoryImpl;

public class DaoFactory {
    public static CategoryImpl getCategoryImpl() {
        return new CategoryImpl();
    }
}
