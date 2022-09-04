package com.exercise.mower.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Business model for the plateau
 */
public class Plateau {

    private int upperX;

    private int upperY;

    private List<Mower> mowers;

    public Plateau(int upperX, int upperY) {
        this.upperX = upperX;
        this.upperY = upperY;
        this.mowers = new ArrayList<>();
    }

    public int getOriginX() {
        return 0;
    }

    public int getOriginY() {
        return 0;
    }

    public int getUpperX() {
        return upperX;
    }

    public int getUpperY() {
        return upperY;
    }

    public List<Mower> getMowers() {
        return mowers;
    }

    public void setMowers(List<Mower> mowers) {
        this.mowers = mowers;
    }
}
