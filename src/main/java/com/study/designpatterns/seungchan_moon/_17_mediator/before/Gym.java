package com.study.designpatterns.seungchan_moon._17_mediator.before;

public class Gym {
    private CleaningService cleaningService;

    public void clean() {
        cleaningService.clean(this);
    }
}
