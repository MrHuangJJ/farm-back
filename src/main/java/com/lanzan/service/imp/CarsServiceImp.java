package com.lanzan.service.imp;

import com.lanzan.dao.CarsMapper;
import com.lanzan.entity.Cars;
import com.lanzan.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "carsService")
public class CarsServiceImp implements CarsService{

    @Autowired
    private CarsMapper carsMapper;

    // 添加Cars
    public void addCars(Cars cars) {
        carsMapper.addCars(cars);
    }

    // 查询全部车辆的carId
    public List<Cars> listCarId() {
        return carsMapper.listCarId();
    }


}
