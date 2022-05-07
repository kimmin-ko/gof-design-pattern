package com.study.designpatterns.seungchan_moon._2_factorymethod.example;

import com.study.designpatterns.seungchan_moon._2_factorymethod.after.BlackShip;
import com.study.designpatterns.seungchan_moon._2_factorymethod.after.WhiteShip;

public class SimpleFactory {
    public Object createProduct(String name) {
        if (name.equals("white")) {
            return new WhiteShip();
        } else if (name.equals("black")) {
            return new BlackShip();
        }
        throw new IllegalArgumentException();
    }
}
