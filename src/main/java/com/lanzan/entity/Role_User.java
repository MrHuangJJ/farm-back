package com.lanzan.entity;

/**
 *
 * 角色-用户
 */
public class Role_User {

    // 角色编号
    private int rid;
    // 用户编号
    private int uid;

    public Role_User() {
    }

    public Role_User(int rid, int uid) {
        this.rid = rid;
        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
