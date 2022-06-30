package com.study.designpatterns.seungchan_moon._21_strategy.after;

public class BlueLightRegLight {
    public void blueLight(Speed speed) {
        speed.blueLight();
    }

    public void redLight(Speed speed) {
        speed.redLight();
    }

//    private Speed speed;
//
//    public BlueLightRegLight(Speed speed) {
//        this.speed = speed;
//    }
//
//    public void blueLight() {
//        speed.blueLight();
//    }
//
//    public void redLight() {
//        speed.redLight();
//    }
}
