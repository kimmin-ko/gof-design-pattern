package com.study.designpatterns.min_kim._23_visitor._2_after;

public interface Device {

    void print(Triangle triangle);

    void print(Circle circle);

    void print(Rectangle rectangle);
}
