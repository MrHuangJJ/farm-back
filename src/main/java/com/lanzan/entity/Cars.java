package com.lanzan.entity;

/**
 *
 * 车辆信息
 */
public class Cars {

    private int carIcon;
    // 车辆编号
    private int carId;
    private String carNO;
    private String machineNO;
    private int serviceStatus;
    private String serviceTime;
    private int teamId;

    public Cars() {
    }

    public Cars(int carIcon, int carId, String carNO, String machineNO, int serviceStatus, String serviceTime, int teamId) {
        this.carIcon = carIcon;
        this.carId = carId;
        this.carNO = carNO;
        this.machineNO = machineNO;
        this.serviceStatus = serviceStatus;
        this.serviceTime = serviceTime;
        this.teamId = teamId;
    }

    public int getCarIcon() {
        return carIcon;
    }

    public void setCarIcon(int carIcon) {
        this.carIcon = carIcon;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarNO() {
        return carNO;
    }

    public void setCarNO(String carNO) {
        this.carNO = carNO;
    }

    public String getMachineNO() {
        return machineNO;
    }

    public void setMachineNO(String machineNO) {
        this.machineNO = machineNO;
    }

    public int getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(int serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "" + carId + "";
    }
}
