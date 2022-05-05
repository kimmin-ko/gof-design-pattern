package com.study.designpatterns.hyeongseok_choi._3_abstractfactory._01_before;

public class WhiteShip extends Ship {
    private WhiteAnchor anchor;
    private WhiteWheel wheel;

    public WhiteAnchor getAnchor() {
        return anchor;
    }

    public void setAnchor(WhiteAnchor anchor) {
        this.anchor = anchor;
    }

    public WhiteWheel getWheel() {
        return wheel;
    }

    public void setWheel(WhiteWheel wheel) {
        this.wheel = wheel;
    }

}
