package com.study.designpatterns.min_kim._3_abstract_factory._car_;

import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.Car;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.carfactory.CarFactory;

public class Customer {

    private final CarFactory carFactory;

    public Customer(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

    public void orderCar() {
        Car car = carFactory.orderCar();
        car.printCarInfo();
    }
}
