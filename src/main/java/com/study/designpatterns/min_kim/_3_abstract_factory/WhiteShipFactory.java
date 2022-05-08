package com.study.designpatterns.min_kim._3_abstract_factory;


import com.study.designpatterns.min_kim._3_abstract_factory.anchor.Anchor;
import com.study.designpatterns.min_kim._3_abstract_factory.ship.Ship;
import com.study.designpatterns.min_kim._3_abstract_factory.ship.WhiteShip;
import com.study.designpatterns.min_kim._3_abstract_factory.wheel.Wheel;

public class WhiteShipFactory implements ShipFactory {

    private ShipPartsFactory shipPartsFactory;

    @Override
    public Ship createShip(String name) {
        WhiteShip whiteship = new WhiteShip(name);
        Anchor anchor = shipPartsFactory.createAnchor();
        Wheel wheel = shipPartsFactory.createWheel();
        whiteship.setAnchor(anchor);
        whiteship.setWheel(wheel);
        return whiteship;
    }
}
