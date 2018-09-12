package com.lanzan.entity;

/**
 *
 * 菜单
 */
public class Meun {

    // 菜单编号
    private int mid;
    // 菜单名称
    private String mname;
    // 菜单图标
    private String micon;
    // 菜单路径
    private String murl;
    // 菜单展开状态
    private String mstate;
    // 菜单等级
    private String mgrade;
    // 菜单父编号
    private String mparent;

    public Meun() {
    }

    public Meun(int mid, String mname, String micon, String murl, String mstate, String mgrade, String mparent) {
        this.mid = mid;
        this.mname = mname;
        this.micon = micon;
        this.murl = murl;
        this.mstate = mstate;
        this.mgrade = mgrade;
        this.mparent = mparent;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMicon() {
        return micon;
    }

    public void setMicon(String micon) {
        this.micon = micon;
    }

    public String getMurl() {
        return murl;
    }

    public void setMurl(String murl) {
        this.murl = murl;
    }

    public String getMstate() {
        return mstate;
    }

    public void setMstate(String mstate) {
        this.mstate = mstate;
    }

    public String getMgrade() {
        return mgrade;
    }

    public void setMgrade(String mgrade) {
        this.mgrade = mgrade;
    }

    public String getMparent() {
        return mparent;
    }

    public void setMparent(String mparent) {
        this.mparent = mparent;
    }
}
