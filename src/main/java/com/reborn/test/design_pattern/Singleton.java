package com.reborn.test.design_pattern;

public class Singleton {
    private static Singleton singleton;
    private Singleton() {}
    static Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
