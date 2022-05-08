package com.study.designpatterns.hyeongseok_choi._1_singleton;

public class SettingsWithStaticInnerClass {

    private SettingsWithStaticInnerClass() {
    }

    /*
    * 5. Static Inner 클래스를 이용한 Holder 싱글톤
    * lazy load가 가능해짐
    * 그러나 해당 패턴을 이용하는 개념 자체가 지나치게 복잡함
    * */
    private static class SettingsHolder {
        private static final SettingsWithStaticInnerClass INSTANCE = new SettingsWithStaticInnerClass();
    }

    public static SettingsWithStaticInnerClass getInstance(){
        return SettingsHolder.INSTANCE;
    }
    
}