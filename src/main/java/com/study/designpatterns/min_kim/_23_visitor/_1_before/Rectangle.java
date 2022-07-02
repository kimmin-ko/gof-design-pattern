package com.study.designpatterns.min_kim._23_visitor._1_before;

public class Rectangle implements Shape {

    @Override
    public void printTo(Device device) {
        if (device instanceof Phone) {
            System.out.println("print rectangle to phone.");
        } else if (device instanceof Watch) {
            System.out.println("print rectangle to watch.");
        }
    }
}
