package com.easyui.controller;

import com.easyui.pojo.Book;
import com.easyui.pojo.Category;
import com.easyui.service.BookService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class DatagridController {

    @Autowired
    private BookService bookService;

    @RequestMapping("category.json")
    @ResponseBody
    public List<Category> categoryList(@RequestParam(defaultValue = "asc") String order) {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "小学"));
        categoryList.add(new Category(2, "初中"));
        categoryList.add(new Category(3, "高中"));
        categoryList.add(new Category(4, "大学"));
        if ("asc".equals(order)) {
            categoryList.sort(Comparator.comparing(Category::getId));
        } else {
            Comparator<Category> comparator = Comparator.comparing(Category::getId);
            categoryList.sort(comparator.reversed());
        }
        return categoryList;
    }

    @RequestMapping("book_list.json")
    @ResponseBody
    public Map<String, Object> bookList(Book book, int page, int rows) {
        PageInfo<Book> bookList = bookService.getBookList(page, rows, book);
        Map<String, Object> map = new HashMap<>();
        map.put("total", bookList.getTotal());
        map.put("rows", bookList.getList());
        return map;
    }

    @RequestMapping("book_detail.json")
    public ModelAndView getBookById(int id) {
        Book book = bookService.getBookById(id);
        return new ModelAndView("/pages/datagrid/detail.jsp", "book", book);
    }
}