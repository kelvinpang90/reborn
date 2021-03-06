package com.reborn.test.design_pattern.abstract_factory;

public abstract class AbstractFactory {
        abstract Shape getShape(String shape);
        abstract Colour getColour(String colour);
}
