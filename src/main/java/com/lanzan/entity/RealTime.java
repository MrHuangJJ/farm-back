package com.lanzan.entity;

public class RealTime {

    private String acode;
    private int carId;
    private int direction;
    private String gpstime;
    private double la;
    private double lat;
    private double lng;
    private double lo;
    private int mileage;
    private boolean online;
    private int pointed;
    private String scode;
    private int speed;
    private int stopTime;
    private String strGGPV;

    public RealTime() {
    }

    public RealTime(String acode, int carId, int direction, String gpstime, double la, double lat, double lng, double lo, int mileage, boolean online, int pointed, String scode, int speed, int stopTime, String strGGPV) {
        this.acode = acode;
        this.carId = carId;
        this.direction = direction;
        this.gpstime = gpstime;
        this.la = la;
        this.lat = lat;
        this.lng = lng;
        this.lo = lo;
        this.mileage = mileage;
        this.online = online;
        this.pointed = pointed;
        this.scode = scode;
        this.speed = speed;
        this.stopTime = stopTime;
        this.strGGPV = strGGPV;
    }

    public String getAcode() {
        return acode;
    }

    public void setAcode(String acode) {
        this.acode = acode;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getGpstime() {
        return gpstime;
    }

    public void setGpstime(String gpstime) {
        this.gpstime = gpstime;
    }

    public double getLa() {
        return la;
    }

    public void setLa(double la) {
        this.la = la;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLo() {
        return lo;
    }

    public void setLo(double lo) {
        this.lo = lo;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public int getPointed() {
        return pointed;
    }

    public void setPointed(int pointed) {
        this.pointed = pointed;
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStopTime() {
        return stopTime;
    }

    public void setStopTime(int stopTime) {
        this.stopTime = stopTime;
    }

    public String getStrGGPV() {
        return strGGPV;
    }

    public void setStrGGPV(String strGGPV) {
        this.strGGPV = strGGPV;
    }
}
