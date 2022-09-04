package com.exercise.mower;

import com.exercise.mower.constant.CommandEnum;
import com.exercise.mower.direction.Direction;
import com.exercise.mower.model.Coordinates;
import com.exercise.mower.model.Mower;
import com.exercise.mower.model.Plateau;

import java.util.ArrayList;
import java.util.List;

import static com.exercise.mower.constant.CommandEnum.A;
import static com.exercise.mower.constant.CommandEnum.D;
import static com.exercise.mower.constant.CommandEnum.G;

public class CommonTests {

    private int upperX = 5;
    private int upperY = 5;

    protected Plateau createPlateau() {
        return new Plateau(new Coordinates(upperX, upperY));
    }

    protected Plateau createPlateauWithMowers() {
        List<Coordinates> mowersCoordinates = new ArrayList<>();
        Plateau plateau = new Plateau(new Coordinates(upperX, upperY));
        mowersCoordinates.add(new Coordinates(4, 5));
        plateau.setMowersCoordinates(mowersCoordinates);
        return plateau;
    }

    protected Mower createMower(int x, int y, Direction direction) {
        return new Mower(createPlateau(), new Coordinates(x, y), direction);
    }

    protected ArrayList<CommandEnum> createCommandList() {
        ArrayList<CommandEnum> commands = new ArrayList<>();
        commands.add(G);
        commands.add(A);
        commands.add(D);
        return commands;
    }
}
