package com.study.designpatterns.hyeongseok_choi._3_abstractfactory._02_after;

public interface ShipFactoryInJava8 {

    default Ship orderShip(String name, String email) {
        validate(name, email);
        prepareFor(name);
        Ship ship = createShip();
        sendEmailTo(name, ship);
        return ship;
    }

    Ship createShip();

    void validate(String name, String email);

    void prepareFor(String name);

    void sendEmailTo(String email, Ship ship);

}
