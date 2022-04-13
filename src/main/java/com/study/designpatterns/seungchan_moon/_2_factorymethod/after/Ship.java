package com.study.designpatterns.seungchan_moon._2_factorymethod.after;

import com.study.designpatterns.seungchan_moon._3_abstract_factory.after.Anchor;
import com.study.designpatterns.seungchan_moon._3_abstract_factory.after.Wheel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Ship {
    private String name;
    private String color;
    private String logo;
    private Wheel wheel;
    private Anchor anchor;

    public Ship() {
    }
}
