package com.study.designpatterns.min_kim._8_composite._2_after;

import java.util.ArrayList;
import java.util.List;

public class Bag implements Component {

    private final List<Component> components = new ArrayList<>();

    @Override
    public int getPrice() {
        return components.stream().mapToInt(Component::getPrice).sum();
    }

    public void add(Component component) {
        this.components.add(component);
    }
}