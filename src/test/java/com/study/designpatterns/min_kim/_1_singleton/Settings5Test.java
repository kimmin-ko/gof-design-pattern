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
        // given when
        Runtime runtime1 = Runtime.getRuntime();
        Runtime runtime2 = Runtime.getRuntime();

        System.out.println("max memory: " + runtime1.maxMemory());
        System.out.println("free memory: " + runtime1.freeMemory());
        System.out.println("available processors: " + runtime1.availableProcessors());

        // then
        assertThat(runtime1).isSameAs(runtime2);
    }

    @Test
    @DisplayName("스프링 빈은 항상 동일한 객체를 반환한다.")
    void spring_bean() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

        // when
        String hello1 = ac.getBean("hello", String.class);
        String hello2 = ac.getBean("hello", String.class);

        // then
        assertThat(hello1).isSameAs(hello2);
    }

}