package com.study.designpatterns.min_kim._8_composite._1_before;

public class Client {

    public static void main(String[] args) {
        Item doranBlade = new Item("도란검", 450);
        Item healingPotion = new Item("물약", 50);

        Bag bag = new Bag();
        bag.add(doranBlade);
        bag.add(healingPotion);

        Client client = new Client();
        client.printItemPrice(doranBlade);
        client.printItemPrice(bag);
    }

    private void printItemPrice(Item item) {
        System.out.println(item.getPrice());
    }

    private void printItemPrice(Bag bag) {
        int price = bag.getItems().stream().mapToInt(Item::getPrice).sum();
        System.out.println(price);
    }
}