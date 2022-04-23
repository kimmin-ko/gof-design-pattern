package com.study.designpatterns.seungchan_moon._3_abstract_factory.after;

import com.study.designpatterns.seungchan_moon._2_factorymethod.after.Ship;
import com.study.designpatterns.seungchan_moon._2_factorymethod.after.ShipFactory;

public class ShipInventory {
    public static void main(String[] args) {
        WhiteShipPartsProFactory pro = new WhiteShipPartsProFactory();
        ShipFactory shipFactory = new WhiteShipFactory(pro);
        Ship ship = shipFactory.createShip();
        System.out.println(ship.getAnchor().getClass());
        System.out.println(ship.getWheel().getClass());
    }
}
