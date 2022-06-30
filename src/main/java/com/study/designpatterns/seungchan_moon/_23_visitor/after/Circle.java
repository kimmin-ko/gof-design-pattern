package com.study.designpatterns.seungchan_moon._23_visitor.after;

public class Circle implements Shape{
//    @Override
//    public void printTo(Phone phone) {
//        System.out.println("print Circle to phone");
//    }
//
//    @Override
//    public void printTo(Watch watch) {
//        System.out.println("print Circle to watch");
//    }

    @Override
    public void accept(Device device) {
        device.print(this);
    }
}
