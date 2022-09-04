package com.exercise.mower.model;

import com.exercise.mower.direction.Direction;

/**
 * Business representation of a mower
 */
public class Mower {

    private final Plateau plateau;

    private Coordinates coordinates;

    private Direction direction;

    public Mower(Plateau plateau, Coordinates coordinates, Direction direction) {

        this.plateau = plateau;
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void turnLeft() {
        this.setDirection(direction.spinLeft(this));
    }

    public void turnRight() {
        this.setDirection(direction.spinRight(this));
    }

    public void goForward() {
        direction.moveForward(this);
    }

}
