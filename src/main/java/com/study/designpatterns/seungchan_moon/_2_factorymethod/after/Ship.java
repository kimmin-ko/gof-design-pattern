package com.study.designpatterns.seungchan_moon._2_factorymethod.after;

import com.study.designpatterns.seungchan_moon._3_abstract_factory.after.Anchor;
import com.study.designpatterns.seungchan_moon._3_abstract_factory.after.Wheel;


public class Ship {
    private String name;
    private String color;
    private String logo;
    private Wheel wheel;
    private Anchor anchor;

    public Ship() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public Anchor getAnchor() {
        return anchor;
    }

    public void setAnchor(Anchor anchor) {
        this.anchor = anchor;
    }
}
