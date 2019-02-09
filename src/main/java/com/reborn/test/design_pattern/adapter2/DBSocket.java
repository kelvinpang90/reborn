package com.reborn.test.design_pattern.adapter2;

public class DBSocket implements DBSocketInterface {
    @Override
    public void powerWithTwoRound() {
        System.out.println("DB socket power on");
    }
}
