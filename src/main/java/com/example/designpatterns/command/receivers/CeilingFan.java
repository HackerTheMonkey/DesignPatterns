package com.example.designpatterns.command.receivers;

public class CeilingFan {

    public static final int OFF = 0;
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;

    private String location;
    private int speed;

    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;
    }

    public void high(){
        System.out.println("The fan speed has been set to HIGH");
        speed = HIGH;
    }

    public void medium(){
        System.out.println("The fan speed has been set to MEDIUM");
        speed = MEDIUM;
    }

    public void low(){
        System.out.println("The fan speed has been set to LOW");
        speed = LOW;
    }

    public void off(){
        System.out.println("The fan speed has been set to OFF");
        speed = OFF;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        switch(speed)
        {
            case 0:
                off();
                break;
            case 1:
                low();
                break;
            case 2:
                medium();
                break;
            case 3:
                high();
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
