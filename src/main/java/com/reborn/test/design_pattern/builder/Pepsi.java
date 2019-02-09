package com.reborn.test.design_pattern.builder;

public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 0.5f;
    }
}
