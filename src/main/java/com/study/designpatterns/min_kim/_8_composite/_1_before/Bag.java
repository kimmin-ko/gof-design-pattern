package com.study.designpatterns.min_kim._8_composite._1_before;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bag {

    private List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        if (items == null) {
            return Collections.emptyList();
        }

        return items;
    }

    public void add(Item item) {
        this.items.add(item);
    }
}
