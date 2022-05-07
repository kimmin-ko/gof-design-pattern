package com.study.designpatterns.geunho_hong._1_singleton;

public class Settings2 {

    private static Settings2 instance;

    private Settings2() {};

    public static synchronized Settings2 getInstance() {
        if(instance == null) {
            return new Settings2();
        }

        return instance;
    }

}
