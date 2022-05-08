package com.study.designpatterns.hyeongseok_choi._2_factorymethod._02_after;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        client.print(new WhiteShipFactory(), "whiteship", "mail1@mail.com");
        client.print(new BlackShipFactory(), "blackship", "mail1@mail.com");
    }

//    클라이언트 코드의 변경도 최소화함
//    일종의 dependency injection으로 볼 수 있음
    private void print(ShipFactory shipFactory, String name, String email) {
        System.out.println(shipFactory.orderShip(name, email));
    }
}
