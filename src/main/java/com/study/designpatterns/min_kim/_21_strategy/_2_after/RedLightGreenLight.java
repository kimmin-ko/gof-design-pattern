package com.study.designpatterns.min_kim._21_strategy._2_after;

public class RedLightGreenLight {

    public void redLight(Speed speed) {
        speed.redLight();
    }

    public void greenLight(Speed speed) {
        speed.greenLight();
    }
}