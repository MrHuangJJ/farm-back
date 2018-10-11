package com.lanzan.entity;

/**
 *
 * 作业季管理
 */
public class HomeworkSeason {

    // 作业季编号
    private int hs_id;
    // 作业季名称
    private String hs_name;
    // 分组名称
    private String hs_grouping;
    // 作业类型
    private String hs_type;
    // 开始时间
    private String hs_beginTime;
    // 结束时间
    private String hs_endTime;
    // 用户编号
    private int uid;

    public HomeworkSeason() {
    }

    public HomeworkSeason(int hs_id, String hs_name, String hs_grouping, String hs_type, String hs_beginTime, String hs_endTime, int uid) {
        this.hs_id = hs_id;
        this.hs_name = hs_name;
        this.hs_grouping = hs_grouping;
        this.hs_type = hs_type;
        this.hs_beginTime = hs_beginTime;
        this.hs_endTime = hs_endTime;
        this.uid = uid;
    }

    public int getHs_id() {
        return hs_id;
    }

    public void setHs_id(int hs_id) {
        this.hs_id = hs_id;
    }

    public String getHs_name() {
        return hs_name;
    }

    public void setHs_name(String hs_name) {
        this.hs_name = hs_name;
    }

    public String getHs_grouping() {
        return hs_grouping;
    }

    public void setHs_grouping(String hs_grouping) {
        this.hs_grouping = hs_grouping;
    }

    public String getHs_type() {
        return hs_type;
    }

    public void setHs_type(String hs_type) {
        this.hs_type = hs_type;
    }

    public String getHs_beginTime() {
        return hs_beginTime;
    }

    public void setHs_beginTime(String hs_beginTime) {
        this.hs_beginTime = hs_beginTime;
    }

    public String getHs_endTime() {
        return hs_endTime;
    }

    public void setHs_endTime(String hs_endTime) {
        this.hs_endTime = hs_endTime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
