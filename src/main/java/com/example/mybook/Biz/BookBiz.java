package com.example.mybook.Biz;

import com.example.mybook.bean.Book;
import com.example.mybook.bean.Record;
import com.example.mybook.bean.Type;
import com.example.mybook.dao.BookDao;
import com.example.mybook.dao.RecordDao;
import com.example.mybook.dao.TypeDao;

import java.sql.SQLException;
import java.util.List;

public class BookBiz {
    BookDao bookDao=new BookDao();
    public List<Book> getBooksByTypeId(long typeId){
        try{
            return bookDao.getBookByTypeId(typeId);
        }catch (SQLException throwables){
            throwables.printStackTrace();
            return null;
        }
    }
    //添加书籍
    public int add(long typeId,String name,double price,String desc,String pic,String publish,String author,long stock,String address){
        int count=0;
        try{
            count= bookDao.add(typeId,name,price,desc,pic,publish,author,stock,address);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return count;
    }
    public int add(Book book){
        return add(book.getTypeId(),book.getName(),book.getPrice(),book.getDesc(),book.getPic(),book.getPublish(),book.getAuthor(),book.getStock(),book.getAddress());
    }
    //修改书籍
    public int modify(long id,long typeId,String name,double price,String desc,String pic,String publish,String author,long stock,String address){
        int count=0;
        try {
            count= bookDao.modify(id,typeId,name,price,desc,pic,publish,author,stock,address);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return count;
    }
    public int modify(Book book){
        int count=0;
        try{
            count= bookDao.modify(book.getId(),book.getTypeId(),book.getName(),book.getPrice(),book.getDesc(),book.getPic(),book.getPublish(),book.getAuthor(),book.getStock(),book.getAddress());
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return count;
    }
    //删除书籍
    public int remove(long id) throws Exception{
        RecordDao recordDao=new RecordDao();
        int count=0;
        try {
//            List<Record> records=recordDao.getRecordByBookId(id);
//            if(records.size()>0){
//                throw new Exception("删除的书籍有子信息，删除失败");
//            }
            count=bookDao.remove(id);

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return count;
    }
    //获取分页对象
    public List<Book> getByPage(int pageIndex,int pageSize){
        TypeDao typeDao=new TypeDao();
        List<Book> books=null;
        try {
            books=bookDao.getByPage(pageIndex,pageSize);
            for(Book book:books){
                long typeId=book.getTypeId();
                book.getType();
                //根据typeid找到对应的type对象
                Type type=typeDao.getById(typeId);
                book.setType(type);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return books;
    }
    //根据id获取
    public Book getById(long id){
        Book book=null;
        TypeDao typeDao=new TypeDao();
        try {
            book = bookDao.getById(id);
            long typeId=book.getTypeId();
            Type type=typeDao.getById(typeId);
            book.setType(type);
        }catch (SQLException throwables){
            throwables.printStackTrace();
            return  null;
        }
        return book;
    }
    //行数转列
    public int getPageCount(int pageSize){
        int pageCount=0;
        try {
            int rowCount=bookDao.getCount();
            //根据行数得到页数，每页多少条
            pageCount=(rowCount-1)/pageSize+1;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return pageCount;
    }
    //根据书籍名
    public Book getByName(String bookName){
        Book book=null;
        try {
            book=bookDao.getByName(bookName);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return book;
    }
}
