package com.study.designpatterns.yunjin_choi._1_singleton;

/**
 * <pre>
 * com.study.designpatterns.yunjin_choi._1_singleton
 *      SynchronizedSample
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-04 오전 1:50
 */

public class SynchronizedSample {
    public static void main(String[] args) {

        new Thread(() -> {
            long start = System.currentTimeMillis();
            System.out.println("시작1 --- ");
            System.out.println(SynchronizedClass.getInstance());
            System.out.println("끝1 --- " + (System.currentTimeMillis() - start));
        }).start();

        new Thread(() -> {
            long start = System.currentTimeMillis();
            System.out.println("시작2 --- ");
            System.out.println(SynchronizedClass.getInstance());
            System.out.println("끝2 --- " + (System.currentTimeMillis() - start));
        }).start();

    }
}


class SynchronizedClass {
    private static SynchronizedClass instance;

    public static synchronized SynchronizedClass getInstance() {
        if (instance == null) {
            instance = new SynchronizedClass();
        }

        return instance;
    }
}
