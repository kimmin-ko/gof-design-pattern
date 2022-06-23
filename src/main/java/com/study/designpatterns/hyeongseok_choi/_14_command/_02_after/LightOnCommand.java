package com.study.designpatterns.hyeongseok_choi._14_command._02_after;

import com.study.designpatterns.hyeongseok_choi._14_command._01_before.Light;

public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        new LightOffCommand(this.light).execute();
    }
}
