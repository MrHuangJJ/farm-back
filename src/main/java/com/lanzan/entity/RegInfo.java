package com.lanzan.entity;

/**
 *
 * 注册信息
 */
public class RegInfo {

    // 用户编号
    private int ri_uid;
    // 用户账号
    private String ri_uname;
    // 用户密码
    private String ri_upass;
    // 用户昵称
    private String ri_uiname;
    // 用户头像
    private String ri_uiphoto;
    // 用户邮箱
    private String ri_uiemail;
    // 用户绑定手机
    private String ri_uiphone;
    // 用户所在城市
    private String ri_uicity;
    // 单位负责人
    private String ri_urprincipal;
    // 组织全称
    private String ri_urfullname;
    // 组织简称
    private String ri_urabbreviation;
    // 组织地址
    private String ri_uraddress;
    // 组织logo
    private String ri_urlogo;
    // 组织执照/介绍信
    private String ri_urlicense;
    // 组织类型
    private String ri_urtype;

    public RegInfo() {
    }

    public RegInfo(int ri_uid, String ri_uname, String ri_upass, String ri_uiname, String ri_uiphoto, String ri_uiemail, String ri_uiphone, String ri_uicity, String ri_urprincipal, String ri_urfullname, String ri_urabbreviation, String ri_uraddress, String ri_urlogo, String ri_urlicense, String ri_urtype) {
        this.ri_uid = ri_uid;
        this.ri_uname = ri_uname;
        this.ri_upass = ri_upass;
        this.ri_uiname = ri_uiname;
        this.ri_uiphoto = ri_uiphoto;
        this.ri_uiemail = ri_uiemail;
        this.ri_uiphone = ri_uiphone;
        this.ri_uicity = ri_uicity;
        this.ri_urprincipal = ri_urprincipal;
        this.ri_urfullname = ri_urfullname;
        this.ri_urabbreviation = ri_urabbreviation;
        this.ri_uraddress = ri_uraddress;
        this.ri_urlogo = ri_urlogo;
        this.ri_urlicense = ri_urlicense;
        this.ri_urtype = ri_urtype;
    }

    public int getRi_uid() {
        return ri_uid;
    }

    public void setRi_uid(int ri_uid) {
        this.ri_uid = ri_uid;
    }

    public String getRi_uname() {
        return ri_uname;
    }

    public void setRi_uname(String ri_uname) {
        this.ri_uname = ri_uname;
    }

    public String getRi_upass() {
        return ri_upass;
    }

    public void setRi_upass(String i_upass) {
        this.ri_upass = i_upass;
    }

    public String getRi_uiname() {
        return ri_uiname;
    }

    public void setRi_uiname(String ri_uiname) {
        this.ri_uiname = ri_uiname;
    }

    public String getRi_uiphoto() {
        return ri_uiphoto;
    }

    public void setRi_uiphoto(String ri_uiphoto) {
        this.ri_uiphoto = ri_uiphoto;
    }

    public String getRi_uiemail() {
        return ri_uiemail;
    }

    public void setRi_uiemail(String ri_uiemail) {
        this.ri_uiemail = ri_uiemail;
    }

    public String getRi_uiphone() {
        return ri_uiphone;
    }

    public void setRi_uiphone(String ri_uiphone) {
        this.ri_uiphone = ri_uiphone;
    }

    public String getRi_uicity() {
        return ri_uicity;
    }

    public void setRi_uicity(String ri_uicity) {
        this.ri_uicity = ri_uicity;
    }

    public String getRi_urprincipal() {
        return ri_urprincipal;
    }

    public void setRi_urprincipal(String ri_urprincipal) {
        this.ri_urprincipal = ri_urprincipal;
    }

    public String getRi_urfullname() {
        return ri_urfullname;
    }

    public void setRi_urfullname(String ri_urfullname) {
        this.ri_urfullname = ri_urfullname;
    }

    public String getRi_urabbreviation() {
        return ri_urabbreviation;
    }

    public void setRi_urabbreviation(String ri_urabbreviation) {
        this.ri_urabbreviation = ri_urabbreviation;
    }

    public String getRi_uraddress() {
        return ri_uraddress;
    }

    public void setRi_uraddress(String ri_uraddress) {
        this.ri_uraddress = ri_uraddress;
    }

    public String getRi_urlogo() {
        return ri_urlogo;
    }

    public void setRi_urlogo(String ri_urlogo) {
        this.ri_urlogo = ri_urlogo;
    }

    public String getRi_urlicense() {
        return ri_urlicense;
    }

    public void setRi_urlicense(String ri_urlicense) {
        this.ri_urlicense = ri_urlicense;
    }

    public String getRi_urtype() {
        return ri_urtype;
    }

    public void setRi_urtype(String ri_urtype) {
        this.ri_urtype = ri_urtype;
    }

}
