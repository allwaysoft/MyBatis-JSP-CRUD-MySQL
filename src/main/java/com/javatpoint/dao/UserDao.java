package com.javatpoint.dao;

import java.util.List;

import com.javatpoint.bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDao {

    public static int save(User user) {
        int status = 0;
        SqlSession session = null;

        try {
            SqlSessionFactory factory = ServiceLocator.getSessionFactory();
            session = factory.openSession();
            status = session.insert("insertUser", user);
            session.commit();

        } finally {

            if (session != null) {
                session.close();
            }
        }
        return status;
    }

    public static int update(User user) {
        int status = 0;
        SqlSession session = null;

        try {
            SqlSessionFactory factory = ServiceLocator.getSessionFactory();
            session = factory.openSession();
            session.update("updateUser", user);
            session.commit();

        } finally {

            if (session != null) {
                session.close();
            }
        }
        return status;
    }

    public static int delete(User user) {
        int status = 0;
        SqlSession session = null;

        try {
            SqlSessionFactory factory = ServiceLocator.getSessionFactory();
            session = factory.openSession();
            session.delete("deleteById", user.getId());
            session.commit();

        } finally {

            if (session != null) {
                session.close();
            }
        }

        return status;
    }

    public static List<User> getAllRecords() {
        SqlSession session = null;
        List<User> retrieveList = null;

        try {
            SqlSessionFactory factory = ServiceLocator.getSessionFactory();
            session = factory.openSession();
            retrieveList = session.selectList("selectAllUsers");

        } finally {

            if (session != null) {
                session.close();
            }
        }

        return retrieveList;
    }

    public static User getRecordById(int id) {
        SqlSession session = null;
        User user = null;

        try {
            SqlSessionFactory factory = ServiceLocator.getSessionFactory();
            session = factory.openSession();
            user = session.selectOne("selectUser", id);

        } finally {

            if (session != null) {
                session.close();
            }
        }

        return user;
    }
}
