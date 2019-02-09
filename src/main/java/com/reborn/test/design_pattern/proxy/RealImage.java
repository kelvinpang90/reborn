package com.reborn.test.design_pattern.proxy;

public class RealImage implements Image {
    @Override
    public void display() {
        System.out.println("display Real Image");
    }
}
