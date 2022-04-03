package com.study.designpatterns.min_kim._1_singleton.session3;

public class Settings {

    private Settings() {
    }

    // synchronized
    private static Settings instance1;

    public static synchronized Settings getInstance1() {
        if (instance1 == null) {
            instance1 = new Settings();
        }
        return instance1;
    }

    // eager initialization
    private static final Settings INSTANCE2 = new Settings();

    public static Settings getInstance2() {
        return INSTANCE2;
    }

    // static block initialization
    private static final Settings INSTANCE3;

    static {
        try {
            INSTANCE3 = new Settings();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    // double-checked locking
    private static volatile Settings instance4;

    public static Settings getInstance4() {
        if (instance4 == null) {
            synchronized (Settings.class) {
                if (instance4 == null) {
                    instance4 = new Settings();
                }
            }
        }
        return instance4;
    }

    // static inner
    private static class SettingsHolder {
        private static final Settings INSTANCE = new Settings();
    }

    public static Settings getInstance5() {
        return SettingsHolder.INSTANCE;
    }
}
