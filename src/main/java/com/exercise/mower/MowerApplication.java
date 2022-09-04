package com.exercise.mower;

import com.exercise.mower.constant.CommandEnum;
import com.exercise.mower.model.Plateau;
import com.exercise.mower.model.Mower;
import com.exercise.mower.service.MowerService;
import com.exercise.mower.utils.InputsUtils;
import com.exercise.mower.utils.LocationUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class MowerApplication {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> inputFileAsList = InputsUtils.parseInputFromFile(Paths.get(Objects.requireNonNull(MowerApplication.class.getClassLoader().getResource("inputs.txt")).toURI()).toString());
        List<String> mowerInput = inputFileAsList.subList(1, inputFileAsList.size());

        System.out.println("Input:" + "\n");
        Stream.of(inputFileAsList)
                .forEach(System.out::println);

        System.out.println("\n" + "Output:" + "\n");
        Plateau plateau = InputsUtils.parsePlateauInput(inputFileAsList.get(0));
        for (int i = 0; i < mowerInput.size(); i += 2) {
            Mower mower = InputsUtils.parsePositionInput(mowerInput.get(i), plateau);
            MowerService mowerService = new MowerService(mower);
            ArrayList<CommandEnum> commands = InputsUtils.parseCommandInput(mowerInput.get(i + 1));
            mowerService.executeCommandList(commands);
            plateau.getMowersCoordinates().add(mower.getCoordinates());
            System.out.println(LocationUtils.showLocation(mower));
        }
    }
}