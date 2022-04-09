package com.study.designpatterns.min_kim._2_factory_method;

import com.study.designpatterns.min_kim._2_factorymethod._02_after.ApplicationConfig;
import com.study.designpatterns.min_kim._2_factorymethod._02_after.Blackship;
import com.study.designpatterns.min_kim._2_factorymethod._02_after.Ship;
import com.study.designpatterns.min_kim._2_factorymethod._02_after.Whiteship;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

class ExampleTest {

    @Test
    @DisplayName("SimpleFactory 패턴")
    void calendar_exam() {
        /*
         * Simple Factory 패턴은 구현체 마다 팩토리 클래스를 정의하는게 아니라
         * 하나의 팩토리 구현체 클래스에서 파라미터 값에 따라 if else 또는 switch로 분기하여 인스턴스를 반환한다.
         */
        System.out.println(Calendar.getInstance());
        System.out.println(Calendar.getInstance(Locale.forLanguageTag("th-TH-x-lvariant-TH")));
        System.out.println(Calendar.getInstance(Locale.forLanguageTag("ja-JP-x-lvariant-JP")));

        Ship ship = SimpleFactory.orderShip("Whiteship");
        assertThat(ship.getClass().getSimpleName()).isEqualTo("Whiteship");
    }

    static abstract class SimpleFactory {

        public static Ship orderShip(String name) {
            if (name.equalsIgnoreCase("whiteship"))
                return new Whiteship(name);
            else if (name.equalsIgnoreCase("blackship"))
                return new Blackship(name);
            else
                throw new IllegalArgumentException(name);
        }
    }

    @Test
    @DisplayName("Creator-Product 팩토리 메소드 패턴")
    void factory_method_pattern() {
        BeanFactory xmlFactory = new ClassPathXmlApplicationContext("~.xml");
        Object hello = xmlFactory.getBean("hello");

        BeanFactory annotationFactory = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Object hello1 = annotationFactory.getBean("hello");
    }

}
