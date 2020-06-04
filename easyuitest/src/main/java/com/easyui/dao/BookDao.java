package com.easyui.dao;

import com.easyui.pojo.Book;

import java.util.List;

public interface BookDao {
    List<Book> getBookList(Book book);
    Book getBookById(int id);
}