package com.study.designpatterns.hyeongseok_choi._2_factorymethod._03_java;

import com.study.designpatterns.hyeongseok_choi._2_factorymethod._02_after.BlackShip;
import com.study.designpatterns.hyeongseok_choi._2_factorymethod._02_after.WhiteShip;

// 심플 팩토리 패턴
public class SimpleFactory {

    public Object createProduct(String name) {
        if (name.equals("whiteship")) {
            return new WhiteShip();
        } else if (name.equals("blackship")) {
            return new BlackShip();
        }
        throw new IllegalArgumentException();
    }
}
