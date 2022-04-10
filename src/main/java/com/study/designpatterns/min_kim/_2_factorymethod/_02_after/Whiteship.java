package com.study.designpatterns.min_kim._2_factorymethod._02_after;

public class Whiteship extends Ship {

    public Whiteship(String name) {
        setName(name);
        setLogo("\uD83D\uDEA2");
        setColor("white");
    }

}
