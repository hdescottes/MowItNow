package com.exercise.mower.direction;

import com.exercise.mower.model.Mower;

public interface Direction {

    Direction spinRight(Mower mower);

    Direction spinLeft(Mower mower);

    void moveForward(Mower mower);

}
