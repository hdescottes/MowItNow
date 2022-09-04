package com.exercise.mower.model;

import com.exercise.mower.direction.Direction;

/**
 * Business representation of a mower
 */
public class Mower {

    private final Plateau plateau;

    private int x;

    private int y;

    private Direction direction;

    public Mower(Plateau plateau, int x, int y, Direction direction) {

        this.plateau = plateau;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
