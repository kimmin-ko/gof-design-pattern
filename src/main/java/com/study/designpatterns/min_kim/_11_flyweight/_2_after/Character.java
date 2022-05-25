package com.study.designpatterns.min_kim._11_flyweight._2_after;

import lombok.Getter;

@Getter
public class Character {
    private char value;
    private String color;
    private Font font;

    public Character(char value, String color, Font font) {
        this.value = value;
        this.color = color;
        this.font = font;
    }
}
