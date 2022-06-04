package com.study.designpatterns.seungchan_moon._14_command.after;

import com.study.designpatterns.seungchan_moon._14_command.before.Light;

public class LightOnCommand implements Command{
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
