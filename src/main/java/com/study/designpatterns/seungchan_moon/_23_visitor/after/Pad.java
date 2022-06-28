package com.study.designpatterns.seungchan_moon._23_visitor.after;

public class Pad implements Device {
    @Override
    public void print(Circle circle) {
        System.out.println("print Circle to Pad");

    }

    @Override
    public void print(Rectangle rectangle) {
        System.out.println("print Rectangle to Pad");

    }

    @Override
    public void print(Triangle triangle) {
        System.out.println("print Triangle to Pad");

    }
}
