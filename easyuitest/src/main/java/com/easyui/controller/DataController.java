package com.easyui.controller;

import com.easyui.pojo.Category;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DataController {
    @RequestMapping("combobox.json")
    @ResponseBody
    public List<Category> combobox() {
        List<Category> list = new ArrayList<>();
        list.add(new Category(1, "图书"));
        list.add(new Category(2, "音响"));
        list.add(new Category(3, "美妆"));
        return list;
    }

    @RequestMapping("combobox_p.json")
    @ResponseBody
    public String combobox(String callback) {
        List<Category> list = new ArrayList<>();
        list.add(new Category(1, "图书"));
        list.add(new Category(2, "音响"));
        list.add(new Category(3, "美妆"));
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return callback + "(" + json + ")";
    }

    @RequestMapping("form.json")
    public String form(String name, String birthday, String lang) {
        System.out.println(name);
        System.out.println(birthday);
        System.out.println(lang);
        return "success.jsp";
    }

}