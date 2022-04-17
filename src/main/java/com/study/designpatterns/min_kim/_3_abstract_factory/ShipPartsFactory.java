package com.study.designpatterns.min_kim._3_abstract_factory;

import com.study.designpatterns.min_kim._3_abstract_factory.anchor.Anchor;
import com.study.designpatterns.min_kim._3_abstract_factory.wheel.Wheel;

public interface ShipPartsFactory {

    Anchor createAnchor();

    Wheel createWheel();

}
