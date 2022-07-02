package com.study.designpatterns.min_kim._23_visitor._2_after;

public class Phone implements Device {

    @Override
    public void print(Triangle triangle) {
        System.out.println("print triangle to phone");
    }

    @Override
    public void print(Circle circle) {
        System.out.println("print circle to phone");
    }

    @Override
    public void print(Rectangle rectangle) {
        System.out.println("print rectangle to phone");
    }
}
