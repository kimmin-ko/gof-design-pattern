package com.study.designpatterns.min_kim._3_abstract_factory_car.carpartfactory;

import com.study.designpatterns.min_kim._3_abstract_factory_car.car.engine.Engine;
import com.study.designpatterns.min_kim._3_abstract_factory_car.car.logo.Logo;
import com.study.designpatterns.min_kim._3_abstract_factory_car.car.wheel.Wheel;

public interface CarPartFactory {
    Logo createLogo();
    Wheel createWheel();
    Engine createEngine();
}
