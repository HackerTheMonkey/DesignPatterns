package com.example.designpatterns.command.commands;

import com.example.designpatterns.command.receivers.CeilingFan;

public class CeilingFanHighCommand implements Command{
    private CeilingFan ceilingFan;
    private int previousSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    @Override
    public void undo() {
        ceilingFan.setSpeed(previousSpeed);
    }
}
