package com.exercise.mower.direction;

import com.exercise.mower.model.Mower;
import com.exercise.mower.utils.LocationUtils;

public class SouthDirection implements Direction {

    @Override
    public Direction spinRight(Mower mower) {
        return new WestDirection();
    }

    @Override
    public Direction spinLeft(Mower mower) {
        return new EastDirection();
    }

    @Override
    public void moveForward(Mower mower) {
        if (LocationUtils.isPositionOk(mower.getCoordinates().getX(), mower.getCoordinates().getY() - 1, mower)) {
            mower.getCoordinates().setY(mower.getCoordinates().getY() - 1);
        }
    }
}
