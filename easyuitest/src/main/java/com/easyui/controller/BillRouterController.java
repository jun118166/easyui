package com.easyui.controller;

import com.easyui.pojo.BillRouter;
import com.easyui.pojo.RouterType;
import com.easyui.service.BillRouterService;
import com.easyui.service.RouterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BillRouterController {

    @Autowired
    private BillRouterService billRouterService;
    @Autowired
    private RouterTypeService orgService;

    @RequestMapping("orgNext.json")
    @ResponseBody
    public String setNextOrg() {
        long start = System.currentTimeMillis();
        //遍历机构表
        List<RouterType> orgs = orgService.list();
        List<BillRouter> bills = billRouterService.list();
        boolean flag;
        for (RouterType org : orgs) {
            flag = false;
            for (BillRouter bill : bills) {
                //判断实际路由是否包含当前组织,存在终止当前循环
                if (StringUtils.isEmpty(bill.getRouterName()) || StringUtils.isEmpty(org.getOrgName())) {
                    continue;
                }
                int index = bill.getRouterName().indexOf(org.getOrgName());
                if (index < 0) {
                    continue;
                }
                String[] strings = bill.getRouterName().split("-");

                if (strings.length == 1) {
                    continue;
                }
                for (int i = 0; i < strings.length; i++) {
                    if (strings[i].equals(org.getOrgName())) {
                        if (org.getType() == 2 && i + 1 < strings.length) {
                            if (strings[i + 1].indexOf("分拨") > 1) {
                                org.setNextOrg(strings[i + 1]);
                                orgService.updateNextOrg(org);
//                                System.out.println("网点-中心" + org);
                                flag = true;
                                break;
                            }
                        } else if (org.getType() == 3 && i - 1 > -1) {
                            if (strings[i - 1].indexOf("分拨") > 1) {
                                org.setNextOrg(strings[i - 1]);
                                orgService.updateNextOrg(org);
//                                System.out.println("中心-网点" + org);
                                flag = true;
                                break;
                            }
                        }
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
        long end = System.currentTimeMillis();
        return (end - start) + "";
    }
}
