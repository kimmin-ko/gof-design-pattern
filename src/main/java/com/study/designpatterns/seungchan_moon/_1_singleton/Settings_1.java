package com.study.designpatterns.seungchan_moon._1_singleton;

public class Settings_1 {
    private static Settings_1 instance;

    private Settings_1() {
    }

    public static Settings_1 getInstance() {
        if (instance == null) {
            instance = new Settings_1();
        }
        return instance;
    }
}
