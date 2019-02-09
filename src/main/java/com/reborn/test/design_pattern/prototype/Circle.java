package com.reborn.test.design_pattern.prototype;

public class Circle extends Shape {
    public Circle() {
        super.type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("draw Circle");
    }
}
