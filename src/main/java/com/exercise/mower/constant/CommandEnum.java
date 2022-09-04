package com.exercise.mower.constant;

import com.exercise.mower.model.Mower;

import java.util.function.Consumer;

/**
 * Constants used for the different possible command
 */
public enum CommandEnum {

    G("LEFT", Mower::turnLeft),
    D("RIGHT", Mower::turnRight),
    A("FORWARD", Mower::goForward);

    private String name;
    private Consumer<Mower> action;

    CommandEnum(String name, Consumer<Mower> action) {
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void doAction(Mower mower) {
        action.accept(mower);
    }
}
