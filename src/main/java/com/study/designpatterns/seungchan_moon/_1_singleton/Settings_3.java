package com.study.designpatterns.seungchan_moon._1_singleton;

public class Settings_3 {
    private static volatile Settings_3 instance;

    private Settings_3() {
    }

    public static Settings_3 getInstance() {
        if (instance == null) {
            synchronized (Settings_3.class) {
                if (instance == null) {
                    instance = new Settings_3();
                }
            }
        }
        return instance;
    }
}
