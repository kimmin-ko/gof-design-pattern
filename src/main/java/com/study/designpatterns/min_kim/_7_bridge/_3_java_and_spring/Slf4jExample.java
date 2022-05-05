package com.study.designpatterns.min_kim._7_bridge._3_java_and_spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jExample {

    private static final Logger logger = LoggerFactory.getLogger(Slf4jExample.class);

    public static void main(String[] args) {
        // log4j
        // log4j2
        // logback
        String name = logger.getClass().getName();
        System.out.println("name = " + name);
    }
}
