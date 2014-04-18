package com.example.designpatterns.command.receivers;

public class Stereo {
    public void on() {
        System.out.println("The stereo has been turned ON");
    }

    public void playCD() {
        System.out.println("The CD is now playing!");
    }

    public void increaseVolume(int volume) {
        System.out.printf("The volume has been set to:%d%n", volume);
    }

    public void off() {
        System.out.println("The stereo has been turned OFF");
    }
}
