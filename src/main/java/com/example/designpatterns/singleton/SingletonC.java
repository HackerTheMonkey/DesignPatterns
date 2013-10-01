package com.example.designpatterns.singleton;


public enum SingletonC implements MyInterface {
    INSTANCE;

    public String someInstanceMember;

    SingletonC(){
        someInstanceMember = "some test value";
    }

    @Override
    public String getFoo() {
        return "bar";
    }
}
