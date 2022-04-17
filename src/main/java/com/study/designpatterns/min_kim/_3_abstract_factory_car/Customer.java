package com.study.designpatterns.min_kim._3_abstract_factory_car;

import com.study.designpatterns.min_kim._3_abstract_factory_car.car.Car;
import com.study.designpatterns.min_kim._3_abstract_factory_car.carfactory.CarFactory;

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
