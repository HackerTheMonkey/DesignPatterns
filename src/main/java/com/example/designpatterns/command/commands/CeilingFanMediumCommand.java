package com.example.designpatterns.command.commands;

import com.example.designpatterns.command.receivers.CeilingFan;

public class CeilingFanMediumCommand implements Command{
    private CeilingFan ceilingFan;
    private int previousSpeed;

    public CeilingFanMediumCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.medium();
    }

    @Override
    public void undo() {
        ceilingFan.setSpeed(previousSpeed);
    }
}
