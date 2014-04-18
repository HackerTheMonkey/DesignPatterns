package com.example.designpatterns.command;

import com.example.designpatterns.command.commands.*;
import com.example.designpatterns.command.invokers.RemoteControl;
import com.example.designpatterns.command.receivers.CeilingFan;
import com.example.designpatterns.command.receivers.Light;
import com.example.designpatterns.command.receivers.Stereo;
import org.junit.Test;

public class RemoteControlTest {
    @Test
    public void the_remote_control_should_properly_turn_appliances_on_and_off() {
        /**
         * Create the receiver objects
         */
        Light light = new Light();
        Stereo stereo = new Stereo();
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        /**
         * Create the command objects that encapsulate the receivers.
         */
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        CeilingFanHighCommand ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
        CeilingFanMediumCommand ceilingFanMediumCommand = new CeilingFanMediumCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

        StereoOnWithCDCommand stereoOnWithCDCommand = new StereoOnWithCDCommand(stereo);
        StereoOffWithCDCommand stereoOffWithCDCommand = new StereoOffWithCDCommand(stereo);
        /**
         * Create the invoker, the remote control in this case and assign
         * commands to it's slots.
         */
        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setSlot(0, lightOnCommand, lightOffCommand);
        remoteControl.setSlot(1, stereoOnWithCDCommand, stereoOffWithCDCommand);
        remoteControl.setSlot(2, ceilingFanHighCommand, ceilingFanOffCommand);
        remoteControl.setSlot(3, ceilingFanMediumCommand, ceilingFanOffCommand);

        /**
         * Simulate the button presses!
         */
        remoteControl.pressOnButton(0);
        remoteControl.pressOffButton(1);
        remoteControl.pressOnButton(2);

        remoteControl.pressUndo();

        remoteControl.pressOffButton(0);
        remoteControl.pressOnButton(1);
        remoteControl.pressOnButton(2);
        remoteControl.pressOffButton(3);

        remoteControl.pressUndo();


    }
}
