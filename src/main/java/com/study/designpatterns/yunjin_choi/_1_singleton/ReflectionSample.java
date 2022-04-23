package com.study.designpatterns.yunjin_choi._1_singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * <pre>
 * com.study.designpatterns.yunjin_choi._1_singleton
 *      ReflectionSample
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-07 오후 11:33
 */

public class ReflectionSample {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        ReflectionSingleTonClass instance = ReflectionSingleTonClass.getInstance();

        Constructor<ReflectionSingleTonClass> constructor= ReflectionSingleTonClass.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        ReflectionSingleTonClass reflectionInstance = constructor.newInstance();

        System.out.println(instance == reflectionInstance);

    }
}


class ReflectionSingleTonClass {

    private static volatile ReflectionSingleTonClass instance;

    public static synchronized ReflectionSingleTonClass getInstance() {
        if (instance == null) {
            synchronized (ReflectionSingleTonClass.class) {
                if (instance == null) {
                    instance = new ReflectionSingleTonClass();
                }
            }
        }
        return instance;
    }
}
