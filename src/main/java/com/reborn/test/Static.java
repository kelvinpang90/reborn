package com.reborn.test;

public class Static {
    protected static String test(String str){
        return str.toUpperCase();
    }
    static {
        System.out.println("static");
    }
}
