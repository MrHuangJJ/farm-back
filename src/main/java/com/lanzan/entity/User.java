package com.lanzan.entity;

/**
 *
 * 用户
 */
public class User {

    //用户编号
    private int uid;
    //用户名
    private String uname;
    //密码
    private String upass;


    public User() {
    }

    public User(int uid, String uname, String upass) {
        this.uid = uid;
        this.uname = uname;
        this.upass = upass;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

}
