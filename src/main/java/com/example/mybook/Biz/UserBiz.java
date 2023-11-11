package com.example.mybook.Biz;

import com.example.mybook.bean.User;
import com.example.mybook.dao.UserDao;

import java.sql.SQLException;

public class UserBiz {
    UserDao userDao = new UserDao();
    public User getUser(String name, String pwd){
        User user = null;
        try {
            user  = userDao.getUser(name,pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
    public int adduser(String name,String pwd){
        int k=0;
        try{
            userDao.add(name,pwd);
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return k;
    }
    public int modifyPwd(long id,String pwd){
        int count=0;
        try{
            count= userDao.modifyPwd(id,pwd);

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return count;
    }
}
