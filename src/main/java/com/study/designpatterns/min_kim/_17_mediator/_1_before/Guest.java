package com.study.designpatterns.min_kim._17_mediator._1_before;

public class Guest {

    private final Restaurant restaurant = new Restaurant();
    private final CleaningService cleaningService = new CleaningService();

    public void dinner() {
        restaurant.dinner(this);
    }

    public void getTowel(int numberOfTowel) {
        cleaningService.getTowel(this, numberOfTowel);
    }
}
