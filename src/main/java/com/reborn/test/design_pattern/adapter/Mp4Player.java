package com.reborn.test.design_pattern.adapter;

public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing Mp4:"+fileName);
    }

    @Override
    public void playVlc(String fileName) {
        //do nothing
    }
}
