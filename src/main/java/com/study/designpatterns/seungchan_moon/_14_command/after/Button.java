package com.study.designpatterns.seungchan_moon._14_command.after;

import com.study.designpatterns.seungchan_moon._14_command.before.Game;
import com.study.designpatterns.seungchan_moon._14_command.before.Light;

import java.util.Stack;

public class Button {
    private Stack<Command> commands = new Stack<>();


    public void press(Command command) {
        command.execute();
        this.commands.push(command);
    }

    public void undo() {
        if(!this.commands.isEmpty()) {
            Command command = this.commands.pop();
            command.undo();
        }
    }

    public static void main(String[] args) {
        Button button = new Button();
        button.press(new GameStartCommand(new Game()));
        button.press(new LightOnCommand(new Light()));
        button.undo();
        button.undo();

    }
}
