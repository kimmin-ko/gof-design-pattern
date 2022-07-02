package com.study.designpatterns.min_kim._23_visitor._2_after;

public class Client {

    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        rectangle.accept(new Phone());

        Shape triangle = new Triangle();
        triangle.accept(new Watch());

        Shape circle = new Circle();
        circle.accept(new Pad());
    }
}