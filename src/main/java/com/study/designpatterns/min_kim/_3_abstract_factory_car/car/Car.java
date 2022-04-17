package com.study.designpatterns.min_kim._3_abstract_factory_car.car;

import com.study.designpatterns.min_kim._3_abstract_factory_car.car.engine.Engine;
import com.study.designpatterns.min_kim._3_abstract_factory_car.car.logo.Logo;
import com.study.designpatterns.min_kim._3_abstract_factory_car.car.wheel.Wheel;

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