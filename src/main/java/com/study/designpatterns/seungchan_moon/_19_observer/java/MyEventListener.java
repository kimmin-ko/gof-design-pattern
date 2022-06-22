package com.study.designpatterns.seungchan_moon._19_observer.java;

//@Component
public class MyEventListener {

//    @EventListener(MyEvent.class)
    public void onApplicationEvent(MyEvent event) {
        System.out.println(event.getMessage());
    }
}
