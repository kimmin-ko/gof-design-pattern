package com.study.designpatterns.seungchan_moon._3_abstract_factory.after;

// 추상 팩토리
public interface ShipPartsFactory {
    Anchor createAnchor();
    Wheel createWheel();
}
