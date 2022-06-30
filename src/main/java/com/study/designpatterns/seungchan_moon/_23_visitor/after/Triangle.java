package com.study.designpatterns.seungchan_moon._23_visitor.after;

public class Triangle implements Shape {

//    @Override
//    public void printTo(Phone phone) {
//        System.out.println("print Triangle to phone");
//    }
//
//    @Override
//    public void printTo(Watch watch) {
//        System.out.println("print Triangle to watch");
//    }

    @Override
    public void accept(Device device) {
        device.print(this);
    }
}
