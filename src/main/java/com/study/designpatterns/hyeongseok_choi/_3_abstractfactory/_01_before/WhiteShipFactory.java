package com.study.designpatterns.hyeongseok_choi._3_abstractfactory._01_before;

public class WhiteShipFactory extends DefaultShipFactoryInJava8 {

//    각 부품들이 바뀜에 따라 코드가 계속 수정되어야 함
    @Override
    public Ship createShip() {
        WhiteShip ship = new WhiteShip();
        ship.setAnchor(new WhiteAnchor());
        ship.setWheel(new WhiteWheel());
        return ship;
    }
}
