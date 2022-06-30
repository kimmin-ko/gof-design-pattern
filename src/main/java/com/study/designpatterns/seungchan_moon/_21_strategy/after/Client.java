package com.study.designpatterns.seungchan_moon._21_strategy.after;

public class Client {
    public static void main(String[] args) {
        BlueLightRegLight blueLightRegLight = new BlueLightRegLight();
        blueLightRegLight.blueLight(new Normal());
        blueLightRegLight.redLight(new Normal());
        blueLightRegLight.redLight(new Speed() {
            @Override
            public void blueLight() {
                System.out.println("무광고티");
            }

            @Override
            public void redLight() {
                System.out.println("폇다");
            }
        });


    }
}
