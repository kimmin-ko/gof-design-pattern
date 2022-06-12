package com.study.designpatterns.min_kim._17_mediator._1_before;

public class CleaningService {

    public void getTowel(Guest guest, int numberOfTowel) {
        System.out.println("get towel " + guest + numberOfTowel);
    }

    public void clean(Gym gym) {
        System.out.println("clean " + gym);
    }

    public void clean(Restaurant restaurant) {
        System.out.println("clean " + restaurant);
    }
}
