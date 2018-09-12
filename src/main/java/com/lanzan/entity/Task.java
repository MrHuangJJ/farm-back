package com.lanzan.entity;

/**
 *
 * 任务
 */
public class Task {

    // 任务编号
    private int tid;
    // 作业面积
    private String tarea;
    // 平均深度/留茬高度
    private String taverage;
    // 深度合格率/高度合格率
    private String tfpy;
    // 农机分组
    private String tgrouping;
    // 驾驶员编号
    private int did;
    // 农机编号
    private int am_id;
    // 作业类型
    private String ttype;
    // 审核状态
    private String tauditState;
    // 上报方式
    private String treportedWay;
    // 审核方式
    private String tauditWay;
    // 审核原因
    private String tauditCause;
    // 开始时间
    private String tbeginTime;
    // 结束时间
    private String tendTime;

    public Task() {
    }

    public Task(int tid, String tarea, String taverage, String tfpy, String tgrouping, int did, int am_id, String ttype, String tauditState, String treportedWay, String tauditWay, String tauditCause, String tbeginTime, String tendTime) {
        this.tid = tid;
        this.tarea = tarea;
        this.taverage = taverage;
        this.tfpy = tfpy;
        this.tgrouping = tgrouping;
        this.did = did;
        this.am_id = am_id;
        this.ttype = ttype;
        this.tauditState = tauditState;
        this.treportedWay = treportedWay;
        this.tauditWay = tauditWay;
        this.tauditCause = tauditCause;
        this.tbeginTime = tbeginTime;
        this.tendTime = tendTime;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getTaverage() {
        return taverage;
    }

    public void setTaverage(String taverage) {
        this.taverage = taverage;
    }

    public String getTfpy() {
        return tfpy;
    }

    public void setTfpy(String tfpy) {
        this.tfpy = tfpy;
    }

    public String getTgrouping() {
        return tgrouping;
    }

    public void setTgrouping(String tgrouping) {
        this.tgrouping = tgrouping;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getAm_id() {
        return am_id;
    }

    public void setAm_id(int am_id) {
        this.am_id = am_id;
    }

    public String getTtype() {
        return ttype;
    }

    public void setTtype(String ttype) {
        this.ttype = ttype;
    }

    public String getTauditState() {
        return tauditState;
    }

    public void setTauditState(String tauditState) {
        this.tauditState = tauditState;
    }

    public String getTreportedWay() {
        return treportedWay;
    }

    public void setTreportedWay(String treportedWay) {
        this.treportedWay = treportedWay;
    }

    public String getTauditWay() {
        return tauditWay;
    }

    public void setTauditWay(String tauditWay) {
        this.tauditWay = tauditWay;
    }

    public String getTauditCause() {
        return tauditCause;
    }

    public void setTauditCause(String tauditCause) {
        this.tauditCause = tauditCause;
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
