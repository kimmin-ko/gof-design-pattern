package com.study.designpatterns.min_kim._3_abstract_factory._car_.carfactory;

import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.Car;

public interface CarFactory {

    default Car orderCar() {
        return createCar();
    }

    Car createCar();

}
