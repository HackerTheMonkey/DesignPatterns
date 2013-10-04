package com.example.designpatterns.singleton;

public class LazySingleton {

    private LazySingleton(){

    }

    /**
     * The LazyInstanceHolder should only be loaded by the JVM when it get
     * referenced, i.e. when the getInstance() method get invoked, not before that. This
     * means that when the JVM loads the LazySingleton class, no "heavy" instances would be
     * created prematurely until its actually needed.
     */
    private static class LazyInstanceHolder{
        public static final LazySingleton INSTANCE = new LazySingleton();
    }

    public static LazySingleton getInstance() {
        return LazyInstanceHolder.INSTANCE;
    }
}
