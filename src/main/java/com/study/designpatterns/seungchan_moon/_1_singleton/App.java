package com.study.designpatterns.seungchan_moon._1_singleton;

import java.io.*;

public class App {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(Settings_1.getInstance() == Settings_1.getInstance());
        System.out.println(Settings_2.getInstance() == Settings_2.getInstance());
        System.out.println(Settings_3.getInstance() == Settings_3.getInstance());
        System.out.println(Settings_4.getInstance() == Settings_4.getInstance());
        System.out.println(Settings_5.INSTANCE == Settings_5.INSTANCE);


        Settings_4 settings = Settings_4.getInstance();
        Settings_4 object = null;
        try (ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
            objectOutput.writeObject(settings);
        }

        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream("settings.obj"))) {
            object = (Settings_4) objectInput.readObject();
        }

        System.out.println(object == settings);
    }
}
