package com.lanzan.entity;

/**
 *
 * 组织信息
 */
public class UserRegister {

    // 用户编号
    private int uid;
    // 单位负责人
    private String ur_principal;
    // 组织全称
    private String ur_fullname;
    // 组织简称
    private String ur_abbreviation;
    // 组织地址
    private String ur_address;
    // 组织logo
    private String ur_logo;
    // 组织执照/介绍信
    private String ur_license;
    //组织类型
    private int ur_type;
    //所属id
    private int ur_parent;

    public UserRegister() {
    }

    public UserRegister(int uid, String ur_principal, String ur_fullname, String ur_abbreviation, String ur_address, String ur_logo, String ur_license, int ur_type) {
        this.uid = uid;
        this.ur_principal = ur_principal;
        this.ur_fullname = ur_fullname;
        this.ur_abbreviation = ur_abbreviation;
        this.ur_address = ur_address;
        this.ur_logo = ur_logo;
        this.ur_license = ur_license;
        this.ur_type = ur_type;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUr_principal() {
        return ur_principal;
    }

    public void setUr_principal(String ur_principal) {
        this.ur_principal = ur_principal;
    }

    public String getUr_fullname() {
        return ur_fullname;
    }

    public void setUr_fullname(String ur_fullname) {
        this.ur_fullname = ur_fullname;
    }

    public String getUr_abbreviation() {
        return ur_abbreviation;
    }

    public void setUr_abbreviation(String ur_abbreviation) {
        this.ur_abbreviation = ur_abbreviation;
    }

    public String getUr_address() {
        return ur_address;
    }

    public void setUr_address(String ur_address) {
        this.ur_address = ur_address;
    }

    public String getUr_logo() {
        return ur_logo;
    }

    public void setUr_logo(String ur_logo) {
        this.ur_logo = ur_logo;
    }

    public String getUr_license() {
        return ur_license;
    }

    public void setUr_license(String ur_license) {
        this.ur_license = ur_license;
    }

    public int getUr_type() {
        return ur_type;
    }

    public void setUr_type(int ur_type) {
        this.ur_type = ur_type;
    }

    public int getUr_parent() {
        return ur_parent;
    }

    public void setUr_parent(int ur_parent) {
        this.ur_parent = ur_parent;
    }
}
