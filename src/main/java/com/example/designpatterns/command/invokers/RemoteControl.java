package com.example.designpatterns.command.invokers;

import com.example.designpatterns.command.commands.Command;
import com.example.designpatterns.command.commands.NothingCommand;

public class RemoteControl {

    private Command[] onCommands = new Command[7];
    private Command[] offCommands = new Command[7];

    public RemoteControl() {
        initDefaults();
    }

    private void initDefaults() {
        initToNothing(onCommands);
        initToNothing(offCommands);
    }

    private void initToNothing(Command[] commands) {
        for(int i = 0 ; i < commands.length ; i++){
            commands[i] = new NothingCommand();
        }
    }

    public void setSlot(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void pressOnButton(int slot) {
        onCommands[slot].execute();
    }

    public void pressOffButton(int slot) {
        offCommands[slot].execute();
    }
}
