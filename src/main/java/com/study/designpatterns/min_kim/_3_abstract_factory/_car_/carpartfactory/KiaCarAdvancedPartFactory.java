package com.study.designpatterns.min_kim._3_abstract_factory._car_.carpartfactory;

import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.engine.Engine;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.engine.KiaTurboEngine;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.logo.KiaRefinedLogo;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.logo.Logo;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.wheel.KiaSportsWheel;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.wheel.Wheel;

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
