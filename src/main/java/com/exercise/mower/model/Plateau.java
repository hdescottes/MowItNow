package com.exercise.mower.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Business model for the plateau
 */
public class Plateau {

    private Coordinates coordinates;

    private List<Coordinates> mowersCoordinates;

    public Plateau(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.mowersCoordinates = new ArrayList<>();
    }

    public int getOriginX() {
        return 0;
    }

    public int getOriginY() {
        return 0;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public List<Coordinates> getMowersCoordinates() {
        return mowersCoordinates;
    }

    public void setMowersCoordinates(List<Coordinates> mowersCoordinates) {
        this.mowersCoordinates = mowersCoordinates;
    }
}
