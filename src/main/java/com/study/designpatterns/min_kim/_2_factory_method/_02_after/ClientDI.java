package com.study.designpatterns.min_kim._2_factory_method._02_after;

// DI를 통해서 Client를 구성하게 되면 ShipFactory가 확장 되어도 Client는 코드 변경이 없다.
public class ClientDI {

    private final ShipFactory shipFactory;

    public ClientDI(ShipFactory shipFactory) {
        this.shipFactory = shipFactory;
    }

    public void print() {
        Ship ship = shipFactory.orderShip("whiteship", "min@mail.com");
        System.out.println("ship = " + ship);
    }

}
