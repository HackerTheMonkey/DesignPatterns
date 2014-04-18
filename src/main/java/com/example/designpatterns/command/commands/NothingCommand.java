package com.example.designpatterns.command.commands;

public class NothingCommand implements Command {
    @Override
    public void execute() {
        // do nothing
    }

    @Override
    public void undo() {
        // do nothing
    }
}
