package com.bitbybit.practice;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void test1() {
        Optional<Integer> optional = Optional.empty();
        Integer integer = optional.orElse(2);
        System.out.println(integer);
    }
}
