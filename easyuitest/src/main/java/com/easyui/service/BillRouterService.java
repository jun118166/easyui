package com.easyui.service;

import com.easyui.dao.BillRouterDao;
import com.easyui.pojo.BillRouter;
import com.easyui.pojo.Book;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillRouterService {
    @Autowired
    private BillRouterDao routerDao;

    public List<BillRouter> list() {
        return routerDao.getBillList();
    }

    public PageInfo<BillRouter> list(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BillRouter> list = routerDao.getBillList();
        PageInfo<BillRouter> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
