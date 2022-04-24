package com.study.designpatterns.hyeongseok_choi._2_factorymethod._01_before;

public class ShipFactory {

    public static Ship orderShip(String name, String email) {
//        validation
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("배 이름을 지어주세요.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("연락처를 남겨주세요.");
        }

        prepareFor(name);

        Ship ship = new Ship();
        ship.setName(name);

//        customization
        if (name.equalsIgnoreCase("whiteship")) {
            ship.setLogo("1");
        } else if (name.equalsIgnoreCase("blackship")) {
            ship.setLogo("2");
        }

        //        coloring
        if (name.equalsIgnoreCase("whiteship")) {
            ship.setColor("white");
        } else if (name.equalsIgnoreCase("blackship")) {
            ship.setColor("black");
        }

//        notify
        sendEmailTo(email, ship);

        return ship;
    }

    private static void prepareFor(String name) {
        System.out.println(name + " 만들 준비 중");
    }

    private static void sendEmailTo(String email, Ship ship) {
        System.out.println(email + " 전송 : " + ship.getName() + " 만들어졌습니다");
    }

}
