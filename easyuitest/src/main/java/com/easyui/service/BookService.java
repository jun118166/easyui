package com.easyui.service;

import com.easyui.dao.BookDao;
import com.easyui.pojo.Book;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public PageInfo<Book> getBookList(int pageNum, int pageSize, Book book) {
        PageHelper.startPage(pageNum, pageSize, "id desc");
        List<Book> books = bookDao.getBookList(book);
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        return pageInfo;
    }

    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }
}