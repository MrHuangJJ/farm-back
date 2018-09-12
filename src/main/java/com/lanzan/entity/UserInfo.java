package com.lanzan.entity;

/**
 *
 * 用户信息
 */
public class UserInfo {

    // 用户编号
    private int uid;
    // 用户昵称
    private String ui_name ;
    // 头像
    private String ui_photo	;
    // 邮箱
    private String ui_email	;
    // 手机号
    private String ui_phone	;
    // 城市
    private String ui_city;

    public UserInfo() {
    }

    public UserInfo(int uid, String ui_name, String ui_photo, String ui_email, String ui_phone, String ui_city) {
        this.uid = uid;
        this.ui_name = ui_name;
        this.ui_photo = ui_photo;
        this.ui_email = ui_email;
        this.ui_phone = ui_phone;
        this.ui_city = ui_city;
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
}
