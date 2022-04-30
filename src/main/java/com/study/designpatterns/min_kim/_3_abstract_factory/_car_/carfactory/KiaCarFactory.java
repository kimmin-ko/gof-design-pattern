package com.study.designpatterns.min_kim._3_abstract_factory._car_.carfactory;

import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.Car;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.KiaCar;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.engine.Engine;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.logo.Logo;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.wheel.Wheel;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.carpartfactory.CarPartFactory;

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
