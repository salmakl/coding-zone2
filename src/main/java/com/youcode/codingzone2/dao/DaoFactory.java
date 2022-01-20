package com.youcode.codingzone2.dao;

import com.youcode.codingzone2.daoImpl.QuizzPickingImpl;
import com.youcode.codingzone2.daoImpl.CategoryImpl;
import com.youcode.codingzone2.daoImpl.QuizzQuestionImpl;
import com.youcode.codingzone2.daoImpl.QuizzesImpl;

public class DaoFactory {
    public static CategoryImpl getCategoryImpl() {
        return new CategoryImpl();
    }
    public  static QuizzQuestionImpl getQuizzQuestionImpl() {
        return new QuizzQuestionImpl();
    }
    public static QuizzesImpl getQuizzesImpl() {
        return new QuizzesImpl();
    }
    public static QuizzPickingImpl getQuizzPickingImpl() {
        return new QuizzPickingImpl();
    }
}
