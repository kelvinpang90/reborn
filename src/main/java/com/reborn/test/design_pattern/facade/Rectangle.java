package com.reborn.test.design_pattern.facade;

public class Rectangle extends Shape {
    public Rectangle() {
        super.type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("draw Rectangle");
    }
}
