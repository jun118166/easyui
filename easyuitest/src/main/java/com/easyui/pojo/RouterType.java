package com.easyui.pojo;

public class RouterType {
    private String orgName;
    private Integer type;
    private String nextOrg;

    @Override
    public String toString() {
        return "RouterType{" +
                "orgName='" + orgName + '\'' +
                ", type=" + type +
                ", nextOrg='" + nextOrg + '\'' +
                '}';
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNextOrg() {
        return nextOrg;
    }

    public void setNextOrg(String nextOrg) {
        this.nextOrg = nextOrg;
    }
}
