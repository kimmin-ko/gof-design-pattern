package com.study.designpatterns.geunho_hong._23_visitor._02_after;

public class Rectangle implements Shape {


    @Override
    public void accept(Device device) {
        device.print(this);
    }
}
