package com.example.designpatterns.singleton;

public class SingletonClient {

    private SingletonA helperSingleton;

    public SingletonClient(SingletonA helperSingleton) {
        this.helperSingleton = helperSingleton;
    }

    public String getFoo() {
        return helperSingleton.getFoo();
    }
}
