package com.exercise.mower.service;

import com.exercise.mower.CommonTests;
import com.exercise.mower.constant.CommandEnum;
import com.exercise.mower.model.Mower;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static com.exercise.mower.constant.CommandEnum.A;
import static com.exercise.mower.constant.CommandEnum.D;
import static com.exercise.mower.direction.DirectionEnum.E;
import static com.exercise.mower.direction.DirectionEnum.N;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MowerServiceTests extends CommonTests {

    private Mower mower = createMower(1, 2, N.getDirection());
    private Mower mower2 = createMower(0, 0, N.getDirection());

    private MowerService mowerServiceTest = new MowerService(mower);
    private MowerService mowerServiceTest2 = new MowerService(mower2);

    @Test
    public void executeCommandList_ShouldSucceed() {
        ArrayList<CommandEnum> commands = createCommandList();
        mowerServiceTest.executeCommandList(commands);
        assertEquals(0, mower.getCoordinates().getX());
        assertEquals(2, mower.getCoordinates().getY());
        assertEquals(N.getDirection().getClass(), mower.getDirection().getClass());
    }

    @Test
    public void executeCommandList_ShouldSucceedWithTwoMowersNoCollision() {
        ArrayList<CommandEnum> commands = createCommandList();
        mowerServiceTest.executeCommandList(commands);
        assertEquals(0, mower.getCoordinates().getX());
        assertEquals(2, mower.getCoordinates().getY());
        assertEquals(N.getDirection().getClass(), mower.getDirection().getClass());

        mower2.getPlateau().setMowersCoordinates(Collections.singletonList(mower.getCoordinates()));
        ArrayList<CommandEnum> commands2 = new ArrayList<>();
        commands2.add(A);
        commands2.add(D);
        commands2.add(A);
        commands2.add(A);
        mowerServiceTest2.executeCommandList(commands2);
        assertEquals(2, mower2.getCoordinates().getX());
        assertEquals(1, mower2.getCoordinates().getY());
        assertEquals(E.getDirection().getClass(), mower2.getDirection().getClass());
    }

    @Test
    public void executeCommandList_ShouldSucceedWithTwoMowersCollision() {
        ArrayList<CommandEnum> commands = createCommandList();
        mowerServiceTest.executeCommandList(commands);
        assertEquals(0, mower.getCoordinates().getX());
        assertEquals(2, mower.getCoordinates().getY());
        assertEquals(N.getDirection().getClass(), mower.getDirection().getClass());

        mower2.getPlateau().setMowersCoordinates(Collections.singletonList(mower.getCoordinates()));
        ArrayList<CommandEnum> commands2 = new ArrayList<>();
        commands2.add(A);
        commands2.add(A);
        commands2.add(D);
        commands2.add(A);
        mowerServiceTest2.executeCommandList(commands2);
        assertEquals(1, mower2.getCoordinates().getX());
        assertEquals(1, mower2.getCoordinates().getY());
        assertEquals(E.getDirection().getClass(), mower2.getDirection().getClass());
    }
}
