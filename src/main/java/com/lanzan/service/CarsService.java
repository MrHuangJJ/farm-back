package com.lanzan.service;

import com.lanzan.entity.Cars;

import java.util.List;

public interface CarsService {

    // 添加Cars
    void addCars(Cars cars);

    // 查询全部车辆的carId
    List<Cars> listCarId();

}
