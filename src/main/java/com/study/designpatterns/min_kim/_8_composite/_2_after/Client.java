package com.study.designpatterns.min_kim._8_composite._2_after;

public class Client {

    public static void main(String[] args) {
        Item doranBlade = new Item("도란검", 450);
        Item healingPotion = new Item("물약", 50);

        Bag bag = new Bag();
        bag.add(doranBlade);
        bag.add(healingPotion);

        Item manaPotion = new Item("파란 물약", 50);
        Bag innerBag = new Bag();
        innerBag.add(manaPotion);

        bag.add(innerBag);

        Client client = new Client();
        client.printPrice(bag);
    }

    private void printPrice(Component component) {
        System.out.println(component.getPrice());
    }
}