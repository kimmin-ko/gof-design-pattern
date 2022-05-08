package com.study.designpatterns.seungchan_moon._3_abstract_factory.after;

import com.study.designpatterns.seungchan_moon._3_abstract_factory.before.WhiteAnchor;
import com.study.designpatterns.seungchan_moon._3_abstract_factory.before.WhiteWheel;

public class WhiteShipPartsFactory implements ShipPartsFactory{

    @Override
    public Anchor createAnchor() {
        return new WhiteAnchor();
    }

    @Override
    public Wheel createWheel() {
        return new WhiteWheel();
    }
}
