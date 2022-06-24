package com.study.designpatterns.min_kim._21_strategy._2_after;

public class Faster implements Speed {

    @Override
    public void redLight() {
        System.out.println("무궁화꽃이");
    }

    @Override
    public void greenLight() {
        System.out.println("피었습니다.");
    }
}
