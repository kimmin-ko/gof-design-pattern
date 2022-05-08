package com.study.designpatterns.min_kim._3_abstract_factory.ship;

import com.study.designpatterns.min_kim._3_abstract_factory.anchor.Anchor;
import com.study.designpatterns.min_kim._3_abstract_factory.wheel.Wheel;

public interface Ship {
    void setName(String name);
    void setAnchor(Anchor anchor);
    void setWheel(Wheel wheel);

    String getName();
    Anchor getAnchor();
    Wheel getWheel();
}
