package com.bitbybit.practice.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiTest {

    public static void main(String[] args) {
        ServiceLoader<Sound> loads = ServiceLoader.load(Sound.class);
        for (Sound load : loads) {
            System.out.println(load.sound());
        }
    }
}
