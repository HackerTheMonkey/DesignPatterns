package com.example.designpatterns.singleton;

import java.io.Serializable;

public class SingletonA implements Serializable{

    public static final SingletonA INSTANCE = new SingletonA();
    public transient String someInstanceMember;
    private String foo;

    private SingletonA(){
        someInstanceMember = "test value";
        if(INSTANCE != null) {
            throw new AssertionError();
        }
    }

    public Object readResolve(){
        return INSTANCE;
    }

    public String getFoo() {
        return foo;
    }
}
