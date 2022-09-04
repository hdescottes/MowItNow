package com.exercise.mower.direction;

import com.exercise.mower.model.Mower;
import com.exercise.mower.utils.LocationUtils;

public class EastDirection implements Direction {

    @Override
    public Direction spinRight(Mower mower) {
        return new SouthDirection();
    }

    @Override
    public Direction spinLeft(Mower mower) {
        return new NorthDirection();
    }

    @Override
    public void moveForward(Mower mower) {
        if (LocationUtils.isPositionOk(mower.getX() + 1, mower.getY(), mower)) {
            mower.setX(mower.getX() + 1);
        }
    }
}