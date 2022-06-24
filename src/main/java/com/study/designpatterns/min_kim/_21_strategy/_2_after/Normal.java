package com.study.designpatterns.min_kim._21_strategy._2_after;

public class Normal implements Speed {

    @Override
    public void redLight() {
        System.out.println("무   궁   화 꽃    이");
    }

    @Override
    public void greenLight() {
        System.out.println("피     었   습  니     다.");
    }
}
