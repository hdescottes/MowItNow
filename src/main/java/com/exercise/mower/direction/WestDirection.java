package com.exercise.mower.direction;

import com.exercise.mower.model.Mower;
import com.exercise.mower.utils.LocationUtils;

public class WestDirection implements Direction {

    @Override
    public Direction spinRight(Mower mower) {
        return new NorthDirection();
    }

    @Override
    public Direction spinLeft(Mower mower) {
        return new SouthDirection();
    }

    @Override
    public void moveForward(Mower mower) {
        if (LocationUtils.isPositionOk(mower.getCoordinates().getX() - 1, mower.getCoordinates().getY(), mower)) {
            mower.getCoordinates().setX(mower.getCoordinates().getX() - 1);
        }
    }
}
