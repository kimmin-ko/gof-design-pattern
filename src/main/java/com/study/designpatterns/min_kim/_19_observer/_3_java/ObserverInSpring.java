package com.study.designpatterns.min_kim._19_observer._3_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;

public class ObserverInSpring {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ObserverInSpring.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }
}
