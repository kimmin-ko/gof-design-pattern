package com.study.designpatterns.min_kim._17_mediator._2_after;

public class Guest {

    private final FrontDesk frontDesk = new FrontDesk();

    private Long id;

    public void getTowels(int numberOfTowels) {
        frontDesk.getTowels(this, numberOfTowels);
    }

    public Long getId() {
        return this.id;
    }
}
