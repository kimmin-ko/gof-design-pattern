package com.study.designpatterns.min_kim._3_abstract_factory._car_.car;

import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.engine.Engine;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.logo.Logo;
import com.study.designpatterns.min_kim._3_abstract_factory._car_.car.wheel.Wheel;

public class HyundaiCar extends Car {

    public HyundaiCar(Logo logo, Wheel wheel, Engine engine) {
        super(logo, wheel, engine);
    }

    @Override
    public void printCarInfo() {
        System.out.println("사용자가 주문한 자동차 정보 --> Name: " + this.getClass().getSimpleName() + ", Logo: " + getLogo().getClass().getSimpleName() + ", Wheel: " + getWheel().getClass().getSimpleName() + ", Engine: " + getEngine().getClass().getSimpleName());
    }
}
