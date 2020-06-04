package com.easyui.controller;

import com.easyui.pojo.TreeNode;
import com.easyui.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TreeController {
    @Autowired
    private TreeService treeService;

    @RequestMapping("tree.json")
    @ResponseBody
    public List<TreeNode> list() {
        return treeService.getTree();
    }

    @RequestMapping("edit_tree.json")
    @ResponseBody
    public Map<String, String> add(TreeNode treeNode) {
        Map<String, String> result = new HashMap<>();
        try {
            if (treeNode.getId() == 0 || treeNode.getId() == null) {
                treeService.addTree(treeNode);
            } else {
                treeService.updateTree(treeNode);
            }
            result.put("status", "true");
            result.put("message", "编辑成功");
        } catch (Exception e) {
            result.put("status", "false");
            result.put("message", "编辑失败");
        }
        return result;
    }

    @RequestMapping("delete_tree.json")
    @ResponseBody
    public Map<String, String> delete(Integer id) {
        Map<String, String> result = new HashMap<>();
        try {
            treeService.deleteTree(id);
            result.put("status", "true");
            result.put("message", "编辑成功");
        } catch (Exception e) {
            result.put("status", "false");
            result.put("message", "编辑失败");
        }
        return result;
    }

    @RequestMapping("batch_delete_tree.json")
    @ResponseBody
    public Map<String, String> batchDelete(int[] ids) {
        Map<String, String> result = new HashMap<>();
        try {
            treeService.deleteTree(ids);
            result.put("status", "true");
            result.put("message", "编辑成功");
        } catch (Exception e) {
            result.put("status", "false");
            result.put("message", "编辑失败");
        }
        return result;
    }
}