package com.study.designpatterns.min_kim._21_strategy._3_java;

import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigBeanDefinitionParser;
import org.springframework.context.annotation.ComponentScanBeanDefinitionParser;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

public class StrategyInSpring {

    public static void main(String[] args) {
        // ApplicationContext -> Strategy
        // 각 구현체 -> ConcreteStrategy
        ApplicationContext ctx1 = new ClassPathXmlApplicationContext();
        ApplicationContext ctx2 = new FileSystemXmlApplicationContext();
        ApplicationContext ctx3 = new AnnotationConfigApplicationContext();

        BeanDefinitionParser parser1 = new ComponentScanBeanDefinitionParser();
        BeanDefinitionParser parser2 = new AnnotationConfigBeanDefinitionParser();

        PlatformTransactionManager platformTransactionManager;

        CacheManager cacheManager;
    }
}
