package com.lanzan.entity;

/**
 *
 * 角色-菜单
 */
public class Role_Meun {

    // 角色编号
    private int rid;
    // 菜单编号
    private int mid;

    public Role_Meun() {
    }

    public Role_Meun(int rid, int mid) {
        this.rid = rid;
        this.mid = mid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }
}
