package com.study.designpatterns.min_kim._21_strategy._2_after;

public class Client {

    public static void main(String[] args) {
        RedLightGreenLight game = new RedLightGreenLight();

        // 각 행동마다 전략 선택 가능
        game.redLight(new Normal());
        game.greenLight(new Fastest());

        // 익명 클래스를 통해 구현 가능
        game.redLight(new Speed() {
            @Override
            public void redLight() {
                System.out.println("redLight");
            }

            @Override
            public void greenLight() {
                System.out.println("greenLight");
            }
        });
    }
}
