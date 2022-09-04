package com.exercise.mower.utils;

import com.exercise.mower.CommonTests;
import com.exercise.mower.constant.CommandEnum;
import com.exercise.mower.model.Plateau;
import com.exercise.mower.model.Mower;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.exercise.mower.constant.CommandEnum.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputsUtilsTests extends CommonTests {

    @Test
    public void parseInputFromFile_ShouldSucceed() throws URISyntaxException, IOException {
        String dest = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource("testInputs.txt")).toURI()).toString();
        List<String> testFileLines = InputsUtils.parseInputFromFile(dest);

        assertEquals(5, testFileLines.size());
        assertEquals("5 5", testFileLines.get(0));
        assertEquals("1 2 N", testFileLines.get(1));
        assertEquals("GAGAGAGAA", testFileLines.get(2));
        assertEquals("3 3 E", testFileLines.get(3));
        assertEquals("AADAADADDA", testFileLines.get(4));
    }

    @Test
    public void parsePlateauInput_ShouldSucceed() {
        String plateauInput = "5 5";
        Plateau plateauOutput = InputsUtils.parsePlateauInput(plateauInput);

        assertEquals(0, plateauOutput.getOriginX());
        assertEquals(0, plateauOutput.getOriginY());
        assertEquals(5, plateauOutput.getCoordinates().getX());
        assertEquals(5, plateauOutput.getCoordinates().getY());
    }

    @Test
    public void parsePositionInput_ShouldSucceed() {
        String positionInput = "1 2 N";
        Mower mowerOutput = InputsUtils.parsePositionInput(positionInput, createPlateau());

        assertEquals(1, mowerOutput.getCoordinates().getX());
        assertEquals(2, mowerOutput.getCoordinates().getY());
        assertEquals('N', mowerOutput.getDirection().getClass().getSimpleName().charAt(0));
    }

    @Test
    public void parseCommandInput_ShouldSucceed() {
        String commandInput = "GAGADGAGAA";
        ArrayList<CommandEnum> commandOutput = InputsUtils.parseCommandInput(commandInput);

        assertEquals(G, commandOutput.get(2));
        assertEquals(D, commandOutput.get(4));
        assertEquals(A, commandOutput.get(8));
    }
}
