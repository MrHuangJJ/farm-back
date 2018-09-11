package com.lanzan.entity;

/**
 *
 * 电子围栏数据
 */
public class ElectronicFence {

    private int ef_id; // 序号
    private String ef_name; // 名称
    private String ef_coordinate; // 坐标
    private String ef_remark; // 备注

    public ElectronicFence() {
    }

    public ElectronicFence(String ef_name, String ef_coordinate, String ef_remark) {
        this.ef_name = ef_name;
        this.ef_coordinate = ef_coordinate;
        this.ef_remark = ef_remark;
    }

    public ElectronicFence(int ef_id, String ef_name, String ef_coordinate, String ef_remark) {
        this.ef_id = ef_id;
        this.ef_name = ef_name;
        this.ef_coordinate = ef_coordinate;
        this.ef_remark = ef_remark;
    }

    public int getEf_id() {
        return ef_id;
    }

    public void setEf_id(int ef_id) {
        this.ef_id = ef_id;
    }

    public String getEf_name() {
        return ef_name;
    }

    public void setEf_name(String ef_name) {
        this.ef_name = ef_name;
    }

    public String getEf_coordinate() {
        return ef_coordinate;
    }

    public void setEf_coordinate(String ef_coordinate) {
        this.ef_coordinate = ef_coordinate;
    }

    public String getEf_remark() {
        return ef_remark;
    }

    public void setEf_remark(String ef_remark) {
        this.ef_remark = ef_remark;
    }
}
