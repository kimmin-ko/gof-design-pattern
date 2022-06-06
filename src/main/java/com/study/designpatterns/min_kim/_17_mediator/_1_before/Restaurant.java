package com.study.designpatterns.min_kim._17_mediator._1_before;

public class Restaurant {

    private final CleaningService cleaningService = new CleaningService();

    public void dinner(Guest guest) {
        System.out.println("dinner " + guest);
    }

    public void clean() {
        cleaningService.clean(this);
    }
}
