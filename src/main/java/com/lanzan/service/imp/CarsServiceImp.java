package com.lanzan.service.imp;

import com.lanzan.dao.CarsMapper;
import com.lanzan.entity.Cars;
import com.lanzan.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service(value = "carsService")
public class CarsServiceImp implements CarsService{

    @Autowired
    private CarsMapper carsMapper;

    // 添加Cars
    public void addCars(Cars cars) {
        carsMapper.addCars(cars);
    }



}
