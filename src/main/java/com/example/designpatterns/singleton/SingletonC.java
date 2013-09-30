package com.example.designpatterns.singleton;


public enum SingletonC {
    INSTANCE;

    public String someInstanceMember;

    SingletonC(){
        someInstanceMember = "some test value";
    }
}
