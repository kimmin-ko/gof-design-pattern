package com.study.designpatterns.min_kim._3_abstractfactory;

public interface ShipPartsFactory {

    Anchor createAnchor();

    Wheel createWheel();

}
