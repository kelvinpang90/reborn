package com.reborn.test.design_pattern.proxy;

public class Test {
    public static void main(String[] args){
        Image image = new ProxyImage();
        image.display();
    }
}
