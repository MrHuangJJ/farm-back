package com.lanzan.dao;

import com.lanzan.entity.Cars;

import java.util.List;

/**
 *
 *盒子信息
 */
public interface CarsMapper {

    // 添加Cars
    void addCars(Cars cars);

    // 查询全部车辆的carId
    List<Cars> listCarId();

}
