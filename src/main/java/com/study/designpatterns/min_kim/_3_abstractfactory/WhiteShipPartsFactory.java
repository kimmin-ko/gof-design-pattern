package com.study.designpatterns.min_kim._3_abstractfactory;

public class WhiteShipPartsFactory implements ShipPartsFactory {

    @Override
    public Anchor createAnchor() {
        return new WhiteShipAnchor();
    }

    @Override
    public Wheel createWheel() {
        return new WhiteShipWheel();
    }
}
