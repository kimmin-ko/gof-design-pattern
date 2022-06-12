package com.study.designpatterns.min_kim._17_mediator._1_before;

public class Gym {

    private final CleaningService cleaningService = new CleaningService();

    public void clean() {
        cleaningService.clean(this);
    }
}
