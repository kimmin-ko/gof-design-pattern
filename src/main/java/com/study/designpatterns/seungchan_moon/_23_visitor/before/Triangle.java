package com.study.designpatterns.seungchan_moon._23_visitor.before;

public class Triangle implements Shape{
    @Override
    public void printTo(Device device) {
        if (device instanceof Phone) {
            System.out.println("폰이야");
        } else if (device instanceof Watch) {
            System.out.println("시계야");
        }
    }
}
