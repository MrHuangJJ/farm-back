package com.lanzan.dao;

import com.lanzan.entity.Cars;

import java.util.List;

public interface CarsMapper {

    // 查询车辆是否在线
    //SELECT * FROM realtime WHERE carId in (SELECT carId FROM cars) ORDER BY gpstime desc LIMIT 1

    // 添加Cars
    void addCars(Cars cars);

    // 查询全部车辆的carId
    List<Cars> listCarId();


}
