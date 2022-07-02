package com.study.designpatterns.min_kim._23_visitor._1_before;

public class Client {

    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        rectangle.printTo(new Phone());

        Shape triangle = new Triangle();
        triangle.printTo(new Phone());
    }
}
