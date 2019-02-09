package com.reborn.test.design_pattern.builder;

public abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }
}
