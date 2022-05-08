package com.study.designpatterns.min_kim._3_abstract_factory._car_.car;

import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.engine.Engine;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.logo.Logo;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.wheel.Wheel;

public abstract class Car {

    protected final Logo logo;
    protected final Wheel wheel;
    protected final Engine engine;

    protected Car(Logo logo, Wheel wheel, Engine engine) {
        this.logo = logo;
        this.wheel = wheel;
        this.engine = engine;
    }

    public Logo getLogo() {
        return this.logo;
    }

    public Wheel getWheel() {
        return this.wheel;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public abstract void printCarInfo();
}