package com.study.designpatterns.min_kim._3_abstract_factory.ship;

import com.study.designpatterns.min_kim._3_abstract_factory.anchor.Anchor;
import com.study.designpatterns.min_kim._3_abstract_factory.wheel.Wheel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WhiteShip implements Ship {
    private String name;
    private Anchor anchor;
    private Wheel wheel;

    public WhiteShip(String name) {
        this.name = name;
    }
}
