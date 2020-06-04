package com.easyui.dao;

import com.easyui.pojo.TreeNode;

import java.util.List;

public interface TreeDao {
    List<TreeNode> list();

    void addTree(TreeNode treeNode);

    void updateTree(TreeNode treeNode);

    void deleteTree(Integer id);

    void updateParentId(Integer id);
}
