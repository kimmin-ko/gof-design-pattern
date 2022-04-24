package com.study.designpatterns.hyeongseok_choi._2_factorymethod._03_java;

import com.study.designpatterns.hyeongseok_choi._2_factorymethod._02_after.DefaultShipFactoryInJava8;
import com.study.designpatterns.hyeongseok_choi._2_factorymethod._02_after.Ship;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanFactory extends DefaultShipFactoryInJava8 {


    @Override
    public Ship createShip() {
        return null;
    }


}
