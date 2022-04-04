package com.study.designpatterns.min_kim._1_singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Session 5: 자바와 스프링에서 찾아보는 패턴")
class Settings5Test {

    @Test
    @DisplayName("자바의 실행 환경 정보를 알고있는 java.lang.Runtime 클래스는 싱글톤 패턴이 적용 되어있다.")
    void runtime() {
        Runtime runtime1 = Runtime.getRuntime();
        Runtime runtime2 = Runtime.getRuntime();

        System.out.println(runtime1.maxMemory());
        System.out.println(runtime1.freeMemory());
        System.out.println(runtime1.availableProcessors());

        assertThat(runtime1).isEqualTo(runtime2);
    }

    @Test
    @DisplayName("스프링 빈은 항상 동일한 객체를 반환한다.")
    void spring_bean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        String hello1 = ac.getBean("hello", String.class);
        String hello2 = ac.getBean("hello", String.class);

        assertThat(hello1 == hello2).isTrue();
    }

}