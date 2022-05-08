package com.study.designpatterns.geunho_hong._1_singleton;

import java.io.*;

public class App {
<<<<<<< HEAD
    public static void main(String[] args) {
        Settings settings = Settings.getInstance();
        System.out.println(settings == Settings.getInstance());
=======

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Settings5 settings = Settings5.INSTANCE;

        Settings5 settings1 = null;
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
            out.writeObject(settings);
        }

        try (ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
            settings1 = (Settings5) in.readObject();
        }

        System.out.println(settings == settings1);
>>>>>>> cd82f7b2841a4102462317a5a3c5d09dd1c8fc85
    }
}
