package com.study.designpatterns.min_kim._21_strategy._1_before;

public class RedLightGreenLight {

    private int speed;

    public RedLightGreenLight(int speed) {
        this.speed = speed;
    }

    public void redLight() {
        if (this.speed == 1) {
            System.out.println("무    궁 화   꽃 이");
        } else if (this.speed == 2) {
            System.out.println("무궁화꽃이");
        } else {
            System.out.println("무광꼬치");
        }
    }

    public void greenLight() {
        if (this.speed == 1) {
            System.out.println("피  었    습 니   다.");
        } else if (this.speed == 2) {
            System.out.println("피었습니다.");
        } else {
            System.out.println("피었씀다.");
        }
    }

}
