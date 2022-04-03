package com.study.designpatterns.yunjin_choi._1_singleton;

import jdk.dynalink.beans.StaticClass;

/**
 * <pre>
 * com.study.designpatterns.yunjin_choi._1_singleton
 *      DoubleCheckedLockingSample
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-04 오전 1:15
 */

public class DoubleCheckedLockingSample {
    public static void main(String[] args) {

        new Thread(() -> {
            long start = System.currentTimeMillis();
            System.out.println("시작1 --- ");
            System.out.println(SingleTonClass.getInstance());
            System.out.println("끝1 --- " + (System.currentTimeMillis() - start));
        }).start();


        new Thread(() -> {
            long start = System.currentTimeMillis();
            System.out.println("시작2 --- ");
            System.out.println(SingleTonClass.getInstance());
            System.out.println("끝2 --- " + (System.currentTimeMillis() - start));
        }).start();
    }
}

class SingleTonClass {

    private static volatile SingleTonClass instance;

    public static synchronized SingleTonClass getInstance() {
        if (instance == null) {
            synchronized (SingleTonClass.class) {
                if (instance == null) {
                    instance = new SingleTonClass();
                }
            }
        }
        return instance;
    }
}
