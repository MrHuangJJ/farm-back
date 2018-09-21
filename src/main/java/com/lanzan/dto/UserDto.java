package com.lanzan.dto;

public class UserDto {

    private int uid;
    private int rid;
    private String uname;

    public UserDto() {
    }

    public UserDto(int uid, int rid, String uname) {
        this.uid = uid;
        this.rid = rid;
        this.uname = uname;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
