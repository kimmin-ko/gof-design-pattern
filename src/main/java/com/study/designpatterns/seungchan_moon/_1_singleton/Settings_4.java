package com.study.designpatterns.seungchan_moon._1_singleton;

import java.io.Serializable;

public class Settings_4 implements Serializable {
    private Settings_4() {
    }

    private static class SettingsHolder {
        private static final Settings_4 INSTANCE = new Settings_4();
    }

    public static Settings_4 getInstance() {
        return SettingsHolder.INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
