package com.study.designpatterns.seungchan_moon._19_observer.java;

public class MyEvent {

    private String message;

    public MyEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
