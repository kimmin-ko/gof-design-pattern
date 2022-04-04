package com.study.designpatterns.min_kim._1_singleton;

public class Settings2 {

    private Settings2() {
    }

    // synchronized
    private static Settings2 instance1;

    public static synchronized Settings2 getInstance1() {
        if (instance1 == null) {
            instance1 = new Settings2();
        }
        return instance1;
    }

    // eager initialization
    private static final Settings2 INSTANCE2 = new Settings2();

    public static Settings2 getInstance2() {
        return INSTANCE2;
    }

    // static block initialization
    private static final Settings2 INSTANCE3;

    static {
        try {
            INSTANCE3 = new Settings2();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    public static Settings2 getInstance3() {
        return INSTANCE3;
    }

    // double-checked locking
    private static volatile Settings2 instance4;

    public static Settings2 getInstance4() {
        if (instance4 == null) {
            synchronized (Settings2.class) {
                if (instance4 == null) {
                    instance4 = new Settings2();
                }
            }
        }
        return instance4;
    }

    // static inner
    private static class SettingsHolder {
        private static final Settings2 INSTANCE = new Settings2();
    }

    public static Settings2 getInstance5() {
        return SettingsHolder.INSTANCE;
    }
}
