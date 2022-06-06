package com.study.designpatterns.min_kim._17_mediator._2_after;

public class CleaningService {

    private final FrontDesk frontDesk = new FrontDesk();

    public void getTowel(Long guestId, int numberOfTowels) {
        String roomNumber = frontDesk.getRoomNumberFor(guestId);
        System.out.println("provide towels " + numberOfTowels + " to " + roomNumber);
    }
}
