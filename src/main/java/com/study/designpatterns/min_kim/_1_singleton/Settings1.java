package com.study.designpatterns.min_kim._1_singleton;

public class Settings1 {

    private static Settings1 instance;

    private Settings1() {
    }

    public static Settings1 getInstance() {
        if (instance == null) {
            instance = new Settings1();
        }

        return instance;
    }
}
