package com.exercise.mower.utils;

import com.exercise.mower.CommonTests;
import com.exercise.mower.model.Coordinates;
import com.exercise.mower.model.Mower;
import com.exercise.mower.model.Plateau;
import org.junit.jupiter.api.Test;

import static com.exercise.mower.direction.DirectionEnum.N;
import static com.exercise.mower.utils.LocationUtils.checkPlateau;
import static com.exercise.mower.utils.LocationUtils.checkPosition;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LocationUtilsTests extends CommonTests {

    @Test
    public void checkPlateau_ShouldFailedCauzNullCoordinates() {
        String[] inputArray = new String[2];
        inputArray[0] = "0";
        inputArray[1] = "0";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> checkPlateau(inputArray))
                .withMessage("The plateau's coordinates must not be null or equal to 0");
    }

    @Test
    public void checkPosition_ShouldFailedCauzMowerIsBeyondPlateau() {
        String[] inputArray = new String[2];
        inputArray[0] = "3";
        inputArray[1] = "9";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> checkPosition(inputArray, createPlateau()))
                .withMessage("The mower's coordinates must not be null or beyond plateau's ones");
    }

    @Test
    public void checkPosition_ShouldFailedCauzMowerIsOnAnotherMower() {
        String[] inputArray = new String[2];
        inputArray[0] = "4";
        inputArray[1] = "5";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> checkPosition(inputArray, createPlateauWithMowers()))
                .withMessage("Another mower is present to those coordinates");
    }

    @Test
    public void isPositionOkOnMowers_ShouldSucceedWithTrue() {
        Plateau plateau = createPlateauWithMowers();
        Mower mower = new Mower(plateau, new Coordinates(3, 5), N.getDirection());

        Boolean check = LocationUtils.isPositionOk(mower.getCoordinates().getX(), mower.getCoordinates().getY(), mower);

        assertThat(check).isTrue();
    }

    @Test
    public void isPositionOkOnMowers_ShouldSucceedWithFalse() {
        Plateau plateau = createPlateauWithMowers();
        Mower mower = new Mower(plateau, new Coordinates(4, 5), N.getDirection());

        Boolean check = LocationUtils.isPositionOk(mower.getCoordinates().getX(), mower.getCoordinates().getY(), mower);

        assertThat(check).isFalse();
    }

    @Test
    public void isPositionOkOnPlateau_ShouldSucceedWithFalse() {
        Mower mower = createMower(5, 5, N.getDirection());

        Boolean check = LocationUtils.isPositionOk( 6, 5, mower);

        assertThat(check).isFalse();
    }
}
