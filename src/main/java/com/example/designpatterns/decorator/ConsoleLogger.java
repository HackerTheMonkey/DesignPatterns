package com.example.designpatterns.decorator;

public class ConsoleLogger implements Logger{
    @Override
    public void log(String message) {
        System.out.println("Logging a message to the console: " + message);
    }
}
