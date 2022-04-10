package com.study.designpatterns.seungchan_moon._1_singleton;

public class Settings_2 {
    private final static Settings_2 INSTANCE = new Settings_2();

    private Settings_2() {
    }

    public static Settings_2 getInstance() {
        return INSTANCE;
    }
}
