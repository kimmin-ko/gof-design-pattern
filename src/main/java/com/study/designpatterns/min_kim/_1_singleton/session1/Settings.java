package com.study.designpatterns.min_kim._1_singleton.session1;

public class Settings {

    private static Settings instance;

    private Settings () {
    }

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }

        return instance;
    }
}
