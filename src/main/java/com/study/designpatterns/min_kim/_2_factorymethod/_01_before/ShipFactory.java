package com.study.designpatterns.min_kim._2_factorymethod._01_before;

import org.springframework.util.StringUtils;

public class ShipFactory {

    /* 문제점
        - 배의 종류가 추가될 수록 orderShip() 메소드가 복잡해진다.
       해결책
        - ShipFactory 인터페이스로 변경하고 각각의 구체 클래스에 대한 구체 팩토리 클래스는 ShipFactory를 구현한다.
     */
    public static Ship orderShip(String name, String email) {
        if (!StringUtils.hasText(name))
            throw new IllegalArgumentException("배 이름을 지어주세요.");
        if (!StringUtils.hasText(email))
            throw new IllegalArgumentException("연락처를 남겨주세요.");

        prepareFor(name);

        Ship ship = new Ship();
        ship.setName(name);

        // 현재는 ship 인스턴스에 name에 따라 분기하여 상태 값을 다르게 주고 있지만,
        // Ship에 다형성이 적용된다면, name에 따라 다른 구체 클래스를 반환해야 한다.
        if (name.equalsIgnoreCase("whiteship"))
            ship.setLogo("\uD83D\uDEA2");
        else if (name.equalsIgnoreCase("blackship"))
            ship.setLogo("⚓");

        if (name.equalsIgnoreCase("whiteship"))
            ship.setColor("white");
        else if (name.equalsIgnoreCase("blackship"))
            ship.setColor("black");

        sendEmailTo(email, ship);

        return ship;
    }

    private static void sendEmailTo(String email, Ship ship) {
        System.out.println(ship.getName() + " 다 만들었습니다.");
    }

    private static void prepareFor(String name) {
        System.out.println(name + " 만들 준비 중");
    }

}
