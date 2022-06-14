package com.study.designpatterns.min_kim._19_observer._3_java;

import java.util.Observable;
import java.util.Observer;

public class ObserverInJava {

    public static void main(String[] args) {
        Subject subject = new Subject();
        User user = new User();
        subject.addObserver(user);
        subject.add("디자인 패턴 공부 !!!");
    }

    static class User implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            System.out.println(arg);
        }
    }

    static class Subject extends Observable {
        public void add(String message) {
            setChanged();
            notifyObservers(message);
        }
    }
}
