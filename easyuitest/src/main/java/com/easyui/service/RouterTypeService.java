package com.easyui.service;

import com.easyui.dao.RouterTypeDao;
import com.easyui.pojo.RouterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouterTypeService {
    @Autowired
    private RouterTypeDao routerTypeDao;

    public List<RouterType> list() {
        return routerTypeDao.getOrgList();
    }

    public void updateNextOrg(RouterType routerType) {
        routerTypeDao.updateNextOrg(routerType);
    }
}
