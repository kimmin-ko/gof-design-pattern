package com.study.designpatterns.min_kim._3_abstract_factory_car.carpartfactory;

import com.study.designpatterns.min_kim._3_abstract_factory_car.car.engine.Engine;
import com.study.designpatterns.min_kim._3_abstract_factory_car.car.engine.KiaEngine;
import com.study.designpatterns.min_kim._3_abstract_factory_car.car.logo.KiaLogo;
import com.study.designpatterns.min_kim._3_abstract_factory_car.car.logo.Logo;
import com.study.designpatterns.min_kim._3_abstract_factory_car.car.wheel.KiaWheel;
import com.study.designpatterns.min_kim._3_abstract_factory_car.car.wheel.Wheel;

public class KiaCarPartFactory implements CarPartFactory {

    @Override
    public Logo createLogo() {
        return new KiaLogo();
    }

    @Override
    public Wheel createWheel() {
        return new KiaWheel();
    }

    @Override
    public Engine createEngine() {
        return new KiaEngine();
    }
}
