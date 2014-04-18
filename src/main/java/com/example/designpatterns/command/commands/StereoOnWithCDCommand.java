package com.example.designpatterns.command.commands;

import com.example.designpatterns.command.receivers.Stereo;

public class StereoOnWithCDCommand implements Command{
    private Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.playCD();
        stereo.increaseVolume(11);
    }
}
