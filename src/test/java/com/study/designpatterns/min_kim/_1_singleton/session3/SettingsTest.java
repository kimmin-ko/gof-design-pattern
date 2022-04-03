package com.study.designpatterns.min_kim._1_singleton.session3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.*;

@DisplayName("싱글톤 패턴 구현 방법을 깨트리는 방법 테스트")
class SettingsTest {

    @Test
    @DisplayName("리플렉션을 사용")
    void use_reflection() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        // given
        Settings settings1 = Settings.getInstance();

        // when use reflection
        Constructor<Settings> constructor = Settings.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Settings settings2 = constructor.newInstance();

        // then
        assertThat(settings1).isNotEqualTo(settings2);
    }

    @Test
    @DisplayName("직렬화 & 역직렬화 사용")
    void use_serializable_and_deserializable() throws IOException, ClassNotFoundException {
        // given
        Settings settings1 = Settings.getInstance();
        Settings settings2;

        // when
        try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
            output.writeObject(settings1);
        }

        try (ObjectInput input = new ObjectInputStream(new FileInputStream("settings.obj"))) {
            settings2 = (Settings) input.readObject();
        }

        // then
        assertThat(settings1).isNotEqualTo(settings2);
    }

}