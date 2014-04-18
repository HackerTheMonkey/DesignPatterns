package com.example.designpatterns.command.receivers;

public class Light {
    public void on() {
        System.out.println("The living room light has been turned ON");
    }

    public void off() {
        System.out.println("The living room light has been turned OFF");
    }
}
