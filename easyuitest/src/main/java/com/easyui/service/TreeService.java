package com.easyui.service;

import com.easyui.dao.TreeDao;
import com.easyui.pojo.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TreeService {

    @Autowired
    private TreeDao treeDao;

    public List<TreeNode> getTree() {
        List<TreeNode> list = treeDao.list();
        Map<Integer, TreeNode> map = new HashMap<>();
        List<TreeNode> parents = new ArrayList<>();
        for (TreeNode node : list) {
            map.put(node.getId(), node);
            if (node.getParentId() == null) {
                parents.add(node);
            }
        }

        for (TreeNode node : list) {
            TreeNode parent = map.get(node.getParentId());
            if (parent != null) {
                parent.getChildren().add(node);
            }
        }

        return parents;
    }

    public void addTree(TreeNode treeNode) {
        treeDao.addTree(treeNode);
    }

    public void updateTree(TreeNode treeNode) {
        treeDao.updateTree(treeNode);
    }

    public void deleteTree(Integer id) {
        treeDao.deleteTree(id);
    }

    public void deleteTree(int[] ids) {
        for (int id : ids) {
            treeDao.deleteTree(id);
            treeDao.updateParentId(id);

        }
    }
}