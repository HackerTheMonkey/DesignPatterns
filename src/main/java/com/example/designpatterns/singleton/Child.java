package com.example.designpatterns.singleton;

class Child extends Parent {

    static{
        System.out.printf("%s: First static initialization block\n", Child.class.getSimpleName());
    }

    public static String foo = initFoo();

    private static String initFoo() {
        System.out.printf("%s: initializing static members\n", Child.class.getSimpleName());
        return "bar";
    }

    public String baz = initBaz();

    {
        System.out.printf("%s: First instance initialization block\n", getClass().getSimpleName());
    }

    private String initBaz() {
        System.out.printf("%s: Initializing instance variables\n", getClass().getSimpleName());
        return "2";
    }

    static{
        System.out.printf("%s: Second static initialization block\n", Child.class.getSimpleName());
    }

    {
        System.out.printf("%s: Second instance initialization block\n", getClass().getSimpleName());
    }


    public Child(){
        foo = "bar";
        System.out.printf("%s: parameter-less constructor: foo: %s\n", getClass().getSimpleName(), foo);
        System.out.printf("%s: parameter-less constructor has been invoked!\n", getClass().getSimpleName());
    }
}
