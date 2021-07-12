package com.bitbybit.practice.spi;

public class DogSound implements Sound{
    @Override
    public String sound() {
        return "wang~wang~wang";
    }
}
