package com.study.designpatterns.geunho_hong._08_composite._01_before;

public class Item {

    private String name;

    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
