package com.study.designpatterns.hyeongseok_choi._1_singleton;

/*
 * 6. Enum을 이용한 싱글톤
 * 리플렉션까지 방지할 수 있음
 * Lazy Load 가 불가능 하다는 단점
 * */
public enum SettingsEnum {

    INSTANCE;
}
