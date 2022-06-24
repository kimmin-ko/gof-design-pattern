package com.study.designpatterns.min_kim._21_strategy._1_before;

public class Client {

    public static void main(String[] args) {
        RedLightGreenLight game = new RedLightGreenLight(1);
        game.redLight();
        game.greenLight();
    }
}
