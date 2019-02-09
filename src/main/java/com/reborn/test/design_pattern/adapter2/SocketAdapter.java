package com.reborn.test.design_pattern.adapter2;

public class SocketAdapter implements DBSocketInterface {
    private GBSocketInterface gbSocketInterface;

    public SocketAdapter(GBSocketInterface gbSocketInterface) {
        this.gbSocketInterface = gbSocketInterface;
    }

    @Override
    public void powerWithTwoRound() {
        gbSocketInterface.powerWithThreeRound();
    }
}
