package com.study.designpatterns.min_kim._1_singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Session 3: 싱글톤 패턴 구현 방법을 깨트리는 방법 테스트")
class Settings3Test {

    @Test
    @DisplayName("리플렉션을 사용하여 싱글톤 패턴 깨트리기")
    void use_reflection() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        // given
        Settings3 settings1 = Settings3.getInstance();

        // when use reflection
        Constructor<Settings3> constructor = Settings3.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Settings3 settings2 = constructor.newInstance();

        // then
        assertThat(settings1).isNotSameAs(settings2);
    }

    @Test
    @DisplayName("직렬화 & 역직렬화 사용하여 싱글톤 패턴 깨트리기")
    void use_serializable_and_deserializable() throws IOException, ClassNotFoundException {
        // given
        Settings3 settings1 = Settings3.getInstance();
        Settings3 settings2;

        // when
        try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
            output.writeObject(settings1);
        }

        try (ObjectInput input = new ObjectInputStream(new FileInputStream("settings.obj"))) {
            settings2 = (Settings3) input.readObject();
        }

        // then
        assertThat(settings1).isNotSameAs(settings2);
    }

}