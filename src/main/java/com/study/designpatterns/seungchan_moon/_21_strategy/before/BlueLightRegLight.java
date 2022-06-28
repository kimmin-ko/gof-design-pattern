package com.study.designpatterns.seungchan_moon._21_strategy.before;

public class BlueLightRegLight {

    private int speed;

    public void blueLight() {
        if (speed == 1) {
            System.out.println("무 궁 화 꽃 이");
        } else if(speed == 2) {
            System.out.println("무궁화꽃이");
        } else if(speed == 2) {
            System.out.println("무광꼬티");
        }
    }

    public void redLight() {
        if (speed == 1) {
            System.out.println("피 었 습 니 다.");
        } else if (speed == 2) {
            System.out.println("피었습니다.");
        } else if (speed == 3) {
            System.out.println("폈슴다.");
        }
    }
}
