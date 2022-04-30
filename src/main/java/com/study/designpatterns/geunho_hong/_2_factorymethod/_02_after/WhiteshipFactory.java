package com.study.designpatterns.geunho_hong._2_factorymethod._02_after;

public class WhiteshipFactory extends DefaultShipFactory {

    @Override
    public Ship createShip() {
        return new Whiteship();
    }
}
