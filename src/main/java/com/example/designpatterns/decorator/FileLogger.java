package com.example.designpatterns.decorator;

public class FileLogger implements Logger{
    @Override
    public void log(String message) {
        System.out.println("Logging a message to a file: " + message);
    }
}
