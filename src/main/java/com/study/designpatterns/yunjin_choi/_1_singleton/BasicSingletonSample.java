package com.study.designpatterns.yunjin_choi._1_singleton;

import jdk.dynalink.beans.StaticClass;

/**
 * <pre>
 * com.study.designpatterns.yunjin_choi._1_singleton
 *      BasicSingletonSample
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-04 오전 1:20
 */

public class BasicSingletonSample {
    public static void main(String[] args) {

        System.out.println(BaseSingletonClass.getInstance());
        System.out.println(BaseSingletonClass.getInstance());
        System.out.println(BaseSingletonClass.getInstance());


//        // singleton이 꺠지는 경우
//        new Thread(() -> {
//            System.out.println(BaseSingletonClass.getInstance());
//        }).start();
//
//        new Thread(() -> {
//            System.out.println(BaseSingletonClass.getInstance());
//        }).start();

    }
}


class BaseSingletonClass {
    private static BaseSingletonClass instance;

    public static BaseSingletonClass getInstance() {
        if (instance == null) {
            instance = new BaseSingletonClass();
        }

        return instance;
    }
}