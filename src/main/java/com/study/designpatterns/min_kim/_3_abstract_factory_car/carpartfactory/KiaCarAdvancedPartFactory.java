package com.study.designpatterns.min_kim._3_abstract_factory_car.carpartfactory;

import com.study.designpatterns.min_kim._3_abstract_factory_car.car.engine.Engine;
import com.study.designpatterns.min_kim._3_abstract_factory_car.car.engine.KiaTurboEngine;
import com.study.designpatterns.min_kim._3_abstract_factory_car.car.logo.KiaRefinedLogo;
import com.study.designpatterns.min_kim._3_abstract_factory_car.car.logo.Logo;
import com.study.designpatterns.min_kim._3_abstract_factory_car.car.wheel.KiaSportsWheel;
import com.study.designpatterns.min_kim._3_abstract_factory_car.car.wheel.Wheel;

public class KiaCarAdvancedPartFactory implements CarPartFactory {

    @Override
    public Logo createLogo() {
        return new KiaRefinedLogo();
    }

    @Override
    public Wheel createWheel() {
        return new KiaSportsWheel();
    }

    @Override
    public Engine createEngine() {
        return new KiaTurboEngine();
    }
}
