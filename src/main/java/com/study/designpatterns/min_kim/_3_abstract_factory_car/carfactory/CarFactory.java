package com.study.designpatterns.min_kim._3_abstract_factory_car.carfactory;

import com.study.designpatterns.min_kim._3_abstract_factory_car.car.Car;

public interface CarFactory {

    default Car orderCar() {
        return createCar();
    }

    Car createCar();

}
