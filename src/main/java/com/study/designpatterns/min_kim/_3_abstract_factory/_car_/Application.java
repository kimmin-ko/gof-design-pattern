package com.study.designpatterns.min_kim._3_abstract_factory._car_;

import com.study.designpatterns.min_kim._3_abstract_factory._car_.carfactory.KiaCarFactory;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.carpartfactory.KiaCarAdvancedPartFactory;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.carpartfactory.KiaCarPartFactory;

public class Application {

    public static void main(String[] args) {
        Customer customer1 = new Customer(new KiaCarFactory(new KiaCarPartFactory()));
        customer1.orderCar();

        Customer customer2 = new Customer(new KiaCarFactory(new KiaCarAdvancedPartFactory()));
        customer2.orderCar();
    }
}