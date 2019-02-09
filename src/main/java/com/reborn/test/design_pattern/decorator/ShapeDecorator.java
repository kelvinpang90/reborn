package com.reborn.test.design_pattern.decorator;

public abstract class ShapeDecorator implements Shape {
    private Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
    }
}
