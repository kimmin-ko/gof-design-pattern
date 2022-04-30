package com.study.designpatterns.min_kim._3_abstract_factory._car_.carpartfactory;

import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.engine.Engine;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.engine.KiaEngine;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.logo.KiaLogo;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.logo.Logo;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.wheel.KiaWheel;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.wheel.Wheel;

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
