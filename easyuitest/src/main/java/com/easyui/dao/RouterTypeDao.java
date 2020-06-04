package com.easyui.dao;

import com.easyui.pojo.RouterType;

import java.util.List;

public interface RouterTypeDao {
    List<RouterType> getOrgList();

    void updateNextOrg(RouterType routerType);
}
