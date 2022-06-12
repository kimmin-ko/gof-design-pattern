package com.study.designpatterns.min_kim._17_mediator._1_before;

public class Hotel {

    public static void main(String[] args) {
        Guest guest = new Guest();
        guest.dinner();
        guest.getTowel(3);

        Restaurant restaurant = new Restaurant();
        restaurant.clean();
    }
}
