package com.exercise.mower.utils;

import com.exercise.mower.model.Coordinates;
import com.exercise.mower.model.Mower;
import com.exercise.mower.model.Plateau;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;

/**
 * Some useful methods for the location
 */
public class LocationUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationUtils.class);

    public static String showLocation(Mower mower) {
        return mower.getCoordinates().getX() + " " + mower.getCoordinates().getY() + " " + mower.getDirection().getClass().getSimpleName().charAt(0);
    }

    static void checkPlateau(String[] inputArray) {
        if (inputArray[0].isEmpty() || inputArray[1].isEmpty() || Integer.parseInt(inputArray[0]) == 0 || Integer.parseInt(inputArray[1]) == 0) {
            throw new IllegalArgumentException("The plateau's coordinates must not be null or equal to 0");
        }
    }

    static void checkPosition(String[] inputArray, Plateau plateau) {
        checkPositionOnPlateau(inputArray, plateau);
        checkPositionWithMowers(inputArray, plateau);
    }

    private static void checkPositionOnPlateau(String[] inputArray, Plateau plateau) {
        if (inputArray[0].isEmpty() || inputArray[1].isEmpty() || Integer.parseInt(inputArray[0]) > plateau.getCoordinates().getX()
                || Integer.parseInt(inputArray[1]) > plateau.getCoordinates().getY()) {
            throw new IllegalArgumentException("The mower's coordinates must not be null or beyond plateau's ones");
        }
    }

    public static void checkPositionWithMowers(String[] inputArray, Plateau plateau) {
        if (plateau.getMowersCoordinates().stream().map(Coordinates::getX).collect(Collectors.toList()).contains(Integer.parseInt(inputArray[0]))
                && plateau.getMowersCoordinates().stream().map(Coordinates::getY).collect(Collectors.toList()).contains(Integer.parseInt(inputArray[1])))
        {
            throw new IllegalArgumentException("Another mower is present to those coordinates");
        }
    }

    public static boolean isPositionOk(int positionX, int positionY, Mower mower) {
        if (mower.getPlateau().getMowersCoordinates().stream().map(Coordinates::getX).collect(Collectors.toList()).contains(positionX)
                && mower.getPlateau().getMowersCoordinates().stream().map(Coordinates::getY).collect(Collectors.toList()).contains(positionY)) {
            LOGGER.info("There is another mower to those coordinates : (" + positionX + ", " + positionY + ")");
            return false;
        } else if (positionX > mower.getPlateau().getCoordinates().getX() || positionX < mower.getPlateau().getOriginX()
                || positionY > mower.getPlateau().getCoordinates().getY() || positionY < mower.getPlateau().getOriginY()) {
            LOGGER.info("Mower cannot go outside the field");
            return false;
        } else {
            return true;
        }
    }
}
