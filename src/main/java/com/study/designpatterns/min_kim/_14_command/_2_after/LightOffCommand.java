package com.study.designpatterns.min_kim._14_command._2_after;

import com.study.designpatterns.min_kim._14_command._1_before.Light;

public class LightOffCommand implements Command {

    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
