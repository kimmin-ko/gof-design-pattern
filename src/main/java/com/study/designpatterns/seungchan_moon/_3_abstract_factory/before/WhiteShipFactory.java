package com.study.designpatterns.seungchan_moon._3_abstract_factory.before;

import com.study.designpatterns.seungchan_moon._2_factorymethod.after.DefaultShipFactory;
import com.study.designpatterns.seungchan_moon._2_factorymethod.after.Ship;
import com.study.designpatterns.seungchan_moon._2_factorymethod.after.WhiteShip;

public class WhiteShipFactory extends DefaultShipFactory {

    @Override
    public Ship createShip() {
        Ship ship = new WhiteShip();
        return ship;
    }
}
