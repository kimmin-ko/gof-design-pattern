package com.study.designpatterns.seungchan_moon._3_abstract_factory.after;

import com.study.designpatterns.seungchan_moon._2_factorymethod.after.DefaultShipFactory;
import com.study.designpatterns.seungchan_moon._2_factorymethod.after.Ship;
import com.study.designpatterns.seungchan_moon._2_factorymethod.after.WhiteShip;
import com.study.designpatterns.seungchan_moon._3_abstract_factory.before.WhiteWheel;

public class WhiteShipFactory extends DefaultShipFactory {

    private ShipPartsFactory shipPartsFactory;

    public WhiteShipFactory(ShipPartsFactory shipPartsFactory) {
        this.shipPartsFactory = shipPartsFactory;
    }

    @Override
    public Ship createShip() {
        Ship ship = new WhiteShip();
        ship.setAnchor(shipPartsFactory.createAnchor());
        ship.setWheel(shipPartsFactory.createWheel());
        return ship;
    }
}
