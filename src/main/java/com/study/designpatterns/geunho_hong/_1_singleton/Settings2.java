<<<<<<< HEAD
package com.study.designpatterns.geunho_hong._1_singleton;

=======
package me.whiteship.designpatterns._01_creational_patterns._01_singleton;

/**
 * synchronized 사용해서 동기화 처리
 */
>>>>>>> cd82f7b2841a4102462317a5a3c5d09dd1c8fc85
public class Settings2 {

    private static Settings2 instance;

<<<<<<< HEAD
    private Settings2() {};

    public static synchronized Settings2 getInstance() {
        if(instance == null) {
            return new Settings2();
=======
    private Settings2() { }

    public static synchronized Settings2 getInstance() {
        if (instance == null) {
            instance = new Settings2();
>>>>>>> cd82f7b2841a4102462317a5a3c5d09dd1c8fc85
        }

        return instance;
    }

}
