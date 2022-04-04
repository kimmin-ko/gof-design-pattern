package com.study.designpatterns.min_kim._1_singleton;

import java.io.Serializable;

public class Settings3 implements Serializable {

    private Settings3() {
    }

    // 객체 역직렬화 시 내부적으로 readResolve() 메서드를 사용하는데 기본적으로 new 연산자를 사용하여 반환한다.
    // 대신에 getInstance() 메서드를 사용하도록 오버라이딩하면 직렬화 & 역직렬화에 대응할 수 있음.
//    protected Object readResolve() {
//        return getInstance1();
//    }

    private static class SettingsHolder {
        private static final Settings3 INSTANCE = new Settings3();
    }

    public static Settings3 getInstance() {
        return SettingsHolder.INSTANCE;
    }
}
