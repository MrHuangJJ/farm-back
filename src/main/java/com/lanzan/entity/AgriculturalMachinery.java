package com.lanzan.entity;

/**
 *
 * 农机
 */
public class AgriculturalMachinery {

    // 农机编号
    private int am_id;
    // 农机车牌
    private String am_licensePlate;
    // 农机分组
    private String am_grouping;
    // 农机型号
    private String am_modelNumber;
    // 农机类型
    private String am_type;
    // 终端编号
    private String am_SN;
    // SIM卡
    private String am_SIM;
    // 农机状态
    private String am_state;

    public AgriculturalMachinery() {
    }

    public AgriculturalMachinery(int am_id, String am_licensePlate, String am_grouping, String am_modelNumber, String am_type, String am_SN, String am_SIM, String am_state) {
        this.am_id = am_id;
        this.am_licensePlate = am_licensePlate;
        this.am_grouping = am_grouping;
        this.am_modelNumber = am_modelNumber;
        this.am_type = am_type;
        this.am_SN = am_SN;
        this.am_SIM = am_SIM;
        this.am_state = am_state;
    }

    public int getAm_id() {
        return am_id;
    }

    public void setAm_id(int am_id) {
        this.am_id = am_id;
    }

    public String getAm_licensePlate() {
        return am_licensePlate;
    }

    public void setAm_licensePlate(String am_licensePlate) {
        this.am_licensePlate = am_licensePlate;
    }

    public String getAm_grouping() {
        return am_grouping;
    }

    public void setAm_grouping(String am_grouping) {
        this.am_grouping = am_grouping;
    }

    public String getAm_modelNumber() {
        return am_modelNumber;
    }

    public void setAm_modelNumber(String am_modelNumber) {
        this.am_modelNumber = am_modelNumber;
    }

    public String getAm_type() {
        return am_type;
    }

    public void setAm_type(String am_type) {
        this.am_type = am_type;
    }

    public String getAm_SN() {
        return am_SN;
    }

    public void setAm_SN(String am_SN) {
        this.am_SN = am_SN;
    }

    public String getAm_SIM() {
        return am_SIM;
    }

    public void setAm_SIM(String am_SIM) {
        this.am_SIM = am_SIM;
    }

    public String getAm_state() {
        return am_state;
    }

    public void setAm_state(String am_state) {
        this.am_state = am_state;
    }
}
