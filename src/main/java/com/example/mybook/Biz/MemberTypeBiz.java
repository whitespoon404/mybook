package com.example.mybook.Biz;

import com.example.mybook.bean.MemberType;
import com.example.mybook.dao.MemberTypeDao;

import java.sql.SQLException;
import java.util.List;

public class MemberTypeBiz {
    MemberTypeDao dao =new MemberTypeDao();
    public List<MemberType> getAll(){
        try {
            return dao.getAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public MemberType getById(long id){
        MemberType memberType = null;

        try {
            memberType = dao.getById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return memberType;

    }
}
