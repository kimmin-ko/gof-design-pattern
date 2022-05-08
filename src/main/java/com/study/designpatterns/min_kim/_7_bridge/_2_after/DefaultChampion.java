package com.study.designpatterns.min_kim._7_bridge._2_after;

public class DefaultChampion implements Champion {

    private final Skin skin;
    private final String name;

    public DefaultChampion(Skin skin, String name) {
        this.skin = skin;
        this.name = name;
    }

    @Override
    public void move() {
        System.out.printf("%s %s 이동", skin.name(), this.name);
    }

    @Override
    public void Q() {
        System.out.printf("%s %s Q 사용", skin.name(), this.name);
    }

    @Override
    public void W() {
        System.out.printf("%s %s W 사용", skin.name(), this.name);
    }

    @Override
    public void E() {
        System.out.printf("%s %s E 사용", skin.name(), this.name);
    }

    @Override
    public void R() {
        System.out.printf("%s %s R 사용", skin.name(), this.name);
    }
}
