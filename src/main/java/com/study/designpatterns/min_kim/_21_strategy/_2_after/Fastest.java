package com.study.designpatterns.min_kim._21_strategy._2_after;

public class Fastest implements Speed {

    @Override
    public void redLight() {
        System.out.println("무광꼬치");
    }

    @Override
    public void greenLight() {
        System.out.println("피어씀다.");
    }
}
