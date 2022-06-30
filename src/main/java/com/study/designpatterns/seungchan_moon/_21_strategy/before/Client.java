package com.study.designpatterns.seungchan_moon._21_strategy.before;

public class Client {
    public static void main(String[] args) {
        BlueLightRegLight blueLightRegLight = new BlueLightRegLight();
        blueLightRegLight.blueLight();
        blueLightRegLight.redLight();
    }
}
