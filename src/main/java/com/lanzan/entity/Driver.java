package com.lanzan.entity;

/**
 *
 * 驾驶员管理
 */
public class Driver {

    // 驾驶员编号
    private int did;
    // 机手分组
    private String dgrouping;
    // 机手姓名
    private String dname;
    // 联系电话
    private String dphone;
    // 身份证号
    private String dcard;

    public Driver() {
    }

    public Driver(int did, String dgrouping, String dname, String dphone, String dcard) {
        this.did = did;
        this.dgrouping = dgrouping;
        this.dname = dname;
        this.dphone = dphone;
        this.dcard = dcard;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDgrouping() {
        return dgrouping;
    }

    public void setDgrouping(String dgrouping) {
        this.dgrouping = dgrouping;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDphone() {
        return dphone;
    }

    public void setDphone(String dphone) {
        this.dphone = dphone;
    }

    public String getDcard() {
        return dcard;
    }

    public void setDcard(String dcard) {
        this.dcard = dcard;
    }
}
