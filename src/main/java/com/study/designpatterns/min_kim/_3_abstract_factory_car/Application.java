package com.study.designpatterns.min_kim._3_abstract_factory_car;

import com.study.designpatterns.min_kim._3_abstract_factory_car.carfactory.KiaCarFactory;
import com.study.designpatterns.min_kim._3_abstract_factory_car.carpartfactory.KiaCarAdvancedPartFactory;
import com.study.designpatterns.min_kim._3_abstract_factory_car.carpartfactory.KiaCarPartFactory;

public class Application {

    public static void main(String[] args) {
        Customer customer1 = new Customer(new KiaCarFactory(new KiaCarPartFactory()));
        customer1.orderCar();

        Customer customer2 = new Customer(new KiaCarFactory(new KiaCarAdvancedPartFactory()));
        customer2.orderCar();
    }
}