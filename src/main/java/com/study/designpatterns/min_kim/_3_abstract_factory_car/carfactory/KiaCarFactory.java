package com.study.designpatterns.min_kim._3_abstract_factory_car.carfactory;

import com.study.designpatterns.min_kim._3_abstract_factory_car.car.Car;
import com.study.designpatterns.min_kim._3_abstract_factory_car.car.KiaCar;
import com.study.designpatterns.min_kim._3_abstract_factory_car.car.engine.Engine;
import com.study.designpatterns.min_kim._3_abstract_factory_car.car.logo.Logo;
import com.study.designpatterns.min_kim._3_abstract_factory_car.car.wheel.Wheel;
import com.study.designpatterns.min_kim._3_abstract_factory_car.carpartfactory.CarPartFactory;

public class KiaCarFactory implements CarFactory {

    private final CarPartFactory carPartFactory;

    public KiaCarFactory(CarPartFactory carPartFactory) {
        this.carPartFactory = carPartFactory;
    }

    @Override
    public Car createCar() {
        Logo logo = carPartFactory.createLogo();
        Wheel wheel = carPartFactory.createWheel();
        Engine engine = carPartFactory.createEngine();

        return new KiaCar(logo, wheel, engine);
    }

}
