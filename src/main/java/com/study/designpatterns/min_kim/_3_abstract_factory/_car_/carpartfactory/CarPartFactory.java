package com.study.designpatterns.min_kim._3_abstract_factory._car_.carpartfactory;

import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.engine.Engine;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.logo.Logo;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.wheel.Wheel;

public interface CarPartFactory {
    Logo createLogo();
    Wheel createWheel();
    Engine createEngine();
}
