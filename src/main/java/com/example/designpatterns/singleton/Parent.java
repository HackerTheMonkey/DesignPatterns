package com.example.designpatterns.singleton;

class Parent {

    public static String fooBar = initFooBar();
    public static final String fooBarBaz = "fooBarBaz";

    private static String initFooBar() {
        System.out.printf("%s: Initializing static members\n", Parent.class.getSimpleName());
        return "fooBar";
    }

    static {
        System.out.printf("%s: first static initialization block\n", Parent.class.getSimpleName());
    }

    {
        System.out.printf("%s: instance initialization block\n", Parent.class.getSimpleName());
    }

    public Parent(){
        System.out.printf("%s: parameter-less constructor has been invoked!\n", Parent.class.getSimpleName());
    }
}
