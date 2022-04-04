package com.study.designpatterns.min_kim._1_singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Constructor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Session 4: 안전하고 단순하게 구현하는 방법")
class Settings4Test {

    @Test
    @DisplayName("enum은 리플렉션으로 인스턴스를 생성할 수 없다.")
    void enums_cannot_create_instances_with_reflection() {
        // given
        Class<Settings4> settingsClass = Settings4.class;

        Constructor<?>[] constructors = settingsClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);

            // fail
            assertThatThrownBy(() -> constructor.newInstance("INSTANCE"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Cannot reflectively create enum objects");
        }
    }

    @Test
    @DisplayName("enum은 직렬화 & 역직렬화 해도 동일한 인스턴스가 반환된다.")
    void the_same_instance_is_returned_even_if_enum_is_serialized_and_deserialized() throws IOException, ClassNotFoundException {
        // given
        Settings4 settings1 = Settings4.INSTANCE;

        // when
        try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
            output.writeObject(settings1);
        }

        Settings4 settings2;
        try (ObjectInput input = new ObjectInputStream(new FileInputStream("settings.obj"))) {
            settings2 = (Settings4) input.readObject();
        }

        // then
        assertThat(settings1).isSameAs(settings2);
    }

}