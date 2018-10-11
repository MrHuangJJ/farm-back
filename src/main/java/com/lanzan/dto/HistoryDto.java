package com.lanzan.dto;

/**
 *
 * 任务历史轨迹列表
 */
public class HistoryDto {


    private int tid;
    private String am_SN;
    private String carNO;
    private String am_licensePlate;
    private String tbeginTime;
    private String tendTime;
    private int uid;

    public HistoryDto() {
    }

    public HistoryDto(int tid, String am_SN, String am_licensePlate, String tbeginTime, String tendTime, int uid) {
        this.tid = tid;
        this.am_SN = am_SN;
        this.am_licensePlate = am_licensePlate;
        this.tbeginTime = tbeginTime;
        this.tendTime = tendTime;
        this.uid = uid;
    }

    public String getAm_SN() {
        return am_SN;
    }

    public void setAm_SN(String am_SN) {
        this.am_SN = am_SN;
    }

    public String getCarNO() {
        return carNO;
    }

    public void setCarNO(String carNO) {
        this.carNO = carNO;
    }

    public String getAm_licensePlate() {
        return am_licensePlate;
    }

    public void setAm_licensePlate(String am_licensePlate) {
        this.am_licensePlate = am_licensePlate;
    }
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTbeginTime() {
        return tbeginTime;
    }

    public void setTbeginTime(String tbeginTime) {
        this.tbeginTime = tbeginTime;
    }

    public String getTendTime() {
        return tendTime;
    }

    public void setTendTime(String tendTime) {
        this.tendTime = tendTime;
    }

}
