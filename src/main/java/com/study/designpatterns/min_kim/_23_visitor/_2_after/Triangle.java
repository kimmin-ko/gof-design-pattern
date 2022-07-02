package com.study.designpatterns.min_kim._23_visitor._2_after;

public class Triangle implements Shape {

    @Override
    public void accept(Device device) {
        device.print(this);
    }
}
