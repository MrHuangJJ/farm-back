package com.lanzan.dto;

/**
 *
 * 个人资料
 */
public class MyDataDto {

    private int uid;// 用户编号
    private String ui_name;// 用户昵称
    private String ui_photo;// 用户头像
    private String ui_email;// 用户邮箱
    private String ui_phone;// 用户绑定手机
    private String ui_city;// 用户所在城市
    private String ur_principal;// 单位负责人
    private String ur_fullname;//	组织全称
    private String ur_abbreviation;// 组织简称
    private String ur_address;// 组织地址
    private String ur_logo;// 组织logo
    private String ur_license;// 组织执照/介绍信
    private String ur_type;// 组织类型

    public MyDataDto() {
    }

    public MyDataDto(int uid, String ui_name, String ui_photo, String ui_email, String ui_phone, String ui_city, String ur_principal, String ur_fullname, String ur_abbreviation, String ur_address, String ur_logo, String ur_license, String ur_type) {
        this.uid = uid;
        this.ui_name = ui_name;
        this.ui_photo = ui_photo;
        this.ui_email = ui_email;
        this.ui_phone = ui_phone;
        this.ui_city = ui_city;
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

    public String getUi_name() {
        return ui_name;
    }

    public void setUi_name(String ui_name) {
        this.ui_name = ui_name;
    }

    public String getUi_photo() {
        return ui_photo;
    }

    public void setUi_photo(String ui_photo) {
        this.ui_photo = ui_photo;
    }

    public String getUi_email() {
        return ui_email;
    }

    public void setUi_email(String ui_email) {
        this.ui_email = ui_email;
    }

    public String getUi_phone() {
        return ui_phone;
    }

    public void setUi_phone(String ui_phone) {
        this.ui_phone = ui_phone;
    }

    public String getUi_city() {
        return ui_city;
    }

    public void setUi_city(String ui_city) {
        this.ui_city = ui_city;
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

    public String getUr_type() {
        return ur_type;
    }

    public void setUr_type(String ur_type) {
        this.ur_type = ur_type;
    }
}
