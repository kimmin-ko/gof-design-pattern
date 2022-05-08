package com.study.designpatterns.min_kim._3_abstract_factory;

import com.study.designpatterns.min_kim._3_abstract_factory.anchor.Anchor;
import com.study.designpatterns.min_kim._3_abstract_factory.anchor.WhiteShipAnchor;
import com.study.designpatterns.min_kim._3_abstract_factory.wheel.Wheel;
import com.study.designpatterns.min_kim._3_abstract_factory.wheel.WhiteShipWheel;

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
