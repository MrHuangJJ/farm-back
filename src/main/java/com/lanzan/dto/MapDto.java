package com.lanzan.dto;

public class MapDto {

    private int am_id;// 农机编号
    private int did;// 驾驶员编号
    private String am_grouping;
    private String am_licensePlate;
    private String am_SN;
    private String am_type;
    private String am_state;
    private String dname;
    private String dphone;
    private String ttype;
    private String tbreadth;
    private String carNO;
    private String carId;

    public MapDto() {

    }

    public MapDto(int am_id, int did, String am_grouping, String am_licensePlate, String am_SN, String am_type, String am_state, String dname, String dphone, String ttype, String tbreadth, String carNO, String carId) {
        this.am_id = am_id;
        this.did = did;
        this.am_grouping = am_grouping;
        this.am_licensePlate = am_licensePlate;
        this.am_SN = am_SN;
        this.am_type = am_type;
        this.am_state = am_state;
        this.dname = dname;
        this.dphone = dphone;
        this.ttype = ttype;
        this.tbreadth = tbreadth;
        this.carNO = carNO;
        this.carId = carId;
    }

    public int getAm_id() {
        return am_id;
    }

    public void setAm_id(int am_id) {
        this.am_id = am_id;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getAm_grouping() {
        return am_grouping;
    }

    public void setAm_grouping(String am_grouping) {
        this.am_grouping = am_grouping;
    }

    public String getAm_licensePlate() {
        return am_licensePlate;
    }

    public void setAm_licensePlate(String am_licensePlate) {
        this.am_licensePlate = am_licensePlate;
    }

    public String getAm_SN() {
        return am_SN;
    }

    public void setAm_SN(String am_SN) {
        this.am_SN = am_SN;
    }

    public String getAm_type() {
        return am_type;
    }

    public void setAm_type(String am_type) {
        this.am_type = am_type;
    }

    public String getAm_state() {
        return am_state;
    }

    public void setAm_state(String am_state) {
        this.am_state = am_state;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDphone() {
        return dphone;
    }

    public void setDphone(String dphone) {
        this.dphone = dphone;
    }

    public String getTtype() {
        return ttype;
    }

    public void setTtype(String ttype) {
        this.ttype = ttype;
    }

    public String getTbreadth() {
        return tbreadth;
    }

    public void setTbreadth(String tbreadth) {
        this.tbreadth = tbreadth;
    }

    public String getCarNO() {
        return carNO;
    }

    public void setCarNO(String carNO) {
        this.carNO = carNO;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }
}
