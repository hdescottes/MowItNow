package com.exercise.mower.service;

import com.exercise.mower.constant.CommandEnum;
import com.exercise.mower.model.Mower;

import java.util.ArrayList;

/**
 * Business logic related to the mower
 */
public class MowerService {

    private Mower mower;

    public MowerService(Mower mower) {
        this.mower = mower;
    }

    public void executeCommandList(ArrayList<CommandEnum> commands) {
        commands.forEach(c -> c.doAction(mower));
    }
}
