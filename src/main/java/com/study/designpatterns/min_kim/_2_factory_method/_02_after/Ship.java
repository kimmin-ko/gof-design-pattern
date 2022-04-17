package com.study.designpatterns.min_kim._2_factory_method._02_after;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Ship {
    private String name;
    private String color;
    private String logo;
}