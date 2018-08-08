package com.lanzan.entity;

/**
 * 验证码
 *
 */
public class VerificationCode {

    //验证码编号
    private int vc_id;

    //手机号
    private String vc_phone;

    //验证码
    private String vc_code;

    //验证码状态
    private String vc_state;

    public VerificationCode() {
    }

    public VerificationCode(String vc_phone, String vc_code, String vc_state) {
        this.vc_phone = vc_phone;
        this.vc_code = vc_code;
        this.vc_state = vc_state;
    }

    public VerificationCode(int vc_id, String vc_phone, String vc_code, String vc_state) {
        this.vc_id = vc_id;
        this.vc_phone = vc_phone;
        this.vc_code = vc_code;
        this.vc_state = vc_state;
    }

    public int getVc_id() {
        return vc_id;
    }

    public void setVc_id(int vc_id) {
        this.vc_id = vc_id;
    }

    public String getVc_phone() {
        return vc_phone;
    }

    public void setVc_phone(String vc_phone) {
        this.vc_phone = vc_phone;
    }

    public String getVc_code() {
        return vc_code;
    }

    public void setVc_code(String vc_code) {
        this.vc_code = vc_code;
    }

    public String getVc_state() {
        return vc_state;
    }

    public void setVc_state(String vc_state) {
        this.vc_state = vc_state;
    }
}
