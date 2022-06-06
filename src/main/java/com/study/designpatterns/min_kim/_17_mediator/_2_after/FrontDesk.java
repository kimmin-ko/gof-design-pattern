package com.study.designpatterns.min_kim._17_mediator._2_after;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;

public class FrontDesk {

    private final CleaningService cleaningService = new CleaningService();

    private final Restaurant restaurant = new Restaurant();

    public void getTowels(Guest guest, int numberOfTowels) {
        cleaningService.getTowel(guest.getId(), numberOfTowels);
    }

    public String getRoomNumberFor(Long guestId) {
        return "1111";
    }

    public void dinner(Guest guest, LocalDateTime dateTime) {
        restaurant.dinner(guest.getId(), dateTime);
    }

}
