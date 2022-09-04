package com.exercise.mower.utils;

import com.exercise.mower.constant.CommandEnum;
import com.exercise.mower.direction.DirectionEnum;
import com.exercise.mower.model.Mower;
import com.exercise.mower.model.Plateau;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Some useful methods for the inputs
 */
public class InputsUtils {

    public static List<String> parseInputFromFile(String fileLocation) throws IOException {
        return Files.lines(Paths.get(fileLocation)).collect(Collectors.toList());
    }

    public static Plateau parsePlateauInput(String plateauInput) {
        String[] inputArray = plateauInput.split(" ");
        LocationUtils.checkPlateau(inputArray);
        return new Plateau(Integer.parseInt(inputArray[0]), Integer.parseInt(inputArray[1]));
    }

    public static Mower parsePositionInput(String positionInput, Plateau plateau) {
        String[] inputArray = positionInput.split(" ");
        LocationUtils.checkPosition(inputArray, plateau);
        return new Mower(plateau, Integer.parseInt(inputArray[0]), Integer.parseInt(inputArray[1]), DirectionEnum.valueOf(inputArray[2]).getDirection());
    }

    public static ArrayList<CommandEnum> parseCommandInput(String command) {
        char[] inputArray = command.toCharArray();
        ArrayList<CommandEnum> commandArrayList = new ArrayList<>();

        for (char character : inputArray) {
            CommandEnum currentCommand = CommandEnum.valueOf(Character.toString(character));
            commandArrayList.add(currentCommand);
        }

        return commandArrayList;
    }

}
