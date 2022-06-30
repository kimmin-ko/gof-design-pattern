package com.study.designpatterns.seungchan_moon._23_visitor.after;

public class Client {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        Device device = new Pad();
        rectangle.accept(device);
    }
}
