package com.example.designpatterns.singleton;

import java.io.Serializable;

public class SingletonB implements Serializable{
    private static final SingletonB INSTANCE = new SingletonB();
    public String someInstanceMember;

    public static SingletonB getInstance() {
        return INSTANCE;
    }

    private SingletonB(){
        someInstanceMember = "Some value";
        if(INSTANCE != null) {
            throw new AssertionError();
        }
    }

    public Object readResolve(){
        return getInstance();
    }
}
