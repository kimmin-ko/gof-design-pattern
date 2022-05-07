package com.study.designpatterns.geunho_hong._08_composite._01_before;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    private List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
