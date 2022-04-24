package com.study.designpatterns.hyeongseok_choi._1_singleton;

import java.io.Serializable;

// serializable은 Singleton을 깨는 예시를 보여주기 위해 추가
public class Settings implements Serializable {

    private static Settings instance;

    private Settings() {
    }

    /*
    * 1. 가장 단순한 싱글톤
    * Thread-Safe 하지 않음
    * */
    public static Settings getInstance(){
        if (instance == null) {
            instance = new Settings();
        }

        return instance;
    }

    /*
    * 2. 싱크로나이즈드 싱글톤
    * 매번 인스턴스를 가져올 때마다 synchronized 블락에 걸리므로 효율적이지 않음
    * */
    public static synchronized Settings getInstanceUsingSynchronized() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    /*
    * 3. Double Checked Locking 싱글톤
    * 싱크로나이즈드 싱글톤의 비효율성을 보완함
    * 그러나 리플렉션을 이용하여 강제로 싱글톤을 깰 수 있음
    * */
    public static Settings getInstanceWithDoubleCheck() {
        if (instance == null) {
            synchronized (Settings.class) {
                if (instance == null) {
                    instance = new Settings();
                }
            }
        }
        return instance;
    }

//    역직렬화 대응 방법
    protected Object readResolve() {
        return getInstance();
    }

}