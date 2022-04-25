package com.study.designpatterns.hyeongseok_choi._1_singleton;

public class SettingsWithEagerInit {

    /*
    * 4. Singleton With Eager Init
    * static final을 이용하여 빠른 가장 단순한 싱글톤에 빠른 초기화를 구현
    * 즉, thread-safe 해짐
    * 그러나 빠른 초기화 자체가 단점으로 작용 (Lazy Load 불가)
    * */
    private static final SettingsWithEagerInit INSTANCE = new SettingsWithEagerInit();

    private SettingsWithEagerInit() {
    }

     public static SettingsWithEagerInit getInstance(){
        return INSTANCE;
    }
    
}