package com.example.mybook.Biz;

import com.example.mybook.bean.Book;
import com.example.mybook.bean.Type;
import com.example.mybook.dao.TypeDao;
import com.example.mybook.dao.BookDao;

import java.sql.SQLException;
import java.util.List;

public class TypeBiz {
    TypeDao typeDao=new TypeDao();
    public List<Type> getAll(){
        try{
            return typeDao.getAll();
        }catch (SQLException throwables){
            throwables.printStackTrace();
            return null;
        }
    }
    public int add(String name,long parentId){
        int count=0;
        try{
            count=typeDao.add(name,parentId);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return count;
    }
    public int modify(long id,String name,long parentId){
        int count=0;
        try{
            count=typeDao.modify(id,name,parentId);

        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return count;
    }
    public int remove(long id) throws Exception{
        BookDao bookDao=new BookDao();
        int count=0;
        try{
            List<Type> all=typeDao.getAll();
            for (Type t:all) {
                List<Book> books = bookDao.getBookByTypeId(id);
                if (t.getParentId()==id) {
                    throw new Exception("删除类型有子信息，删除失败");
                }
            }
            List<Book> books=bookDao.getBookByTypeId(id);
            if (books.size()>0){
                throw new Exception("删除类型有子信息，删除失败");
            }
            count=typeDao.remove(id);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return count;
    }
    public Type getById(long id){
        try{
            return typeDao.getById(id);

        }catch (SQLException throwables){
            throwables.printStackTrace();
            return null;
        }
    }
}
