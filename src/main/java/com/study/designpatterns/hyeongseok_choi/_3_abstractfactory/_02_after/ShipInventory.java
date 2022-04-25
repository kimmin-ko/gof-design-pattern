package com.study.designpatterns.hyeongseok_choi._3_abstractfactory._02_after;


public class ShipInventory {
    public static void main(String[] args) {
        // 제품군을 제공하는 역할을 WhiteShipPartsFactory로 위임하였음 -> SRP 원칙
        // 기본 코드를 변경하지 않고 제품군을 확장할 수 있음 -> OCP
        ShipFactoryInJava8 shipFactory = new WhiteShipFactory(new WhitePartsProFactory());
//        ShipFactoryInJava8 shipFactory = new WhiteShipFactory(new WhiteShipPartsFactory());
        Ship ship = shipFactory.createShip();
        System.out.println(ship.getAnchor().getClass());
        System.out.println(ship.getWheel().getClass());
    }
}
