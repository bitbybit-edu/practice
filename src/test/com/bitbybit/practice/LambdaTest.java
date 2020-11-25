package com.bitbybit.practice;

import org.junit.Test;

public class LambdaTest {

    @Test
    public void print() {
        MathOperation add = (a, b) -> a + b;
        System.out.println(add.operation(3, 2));
    }

    interface MathOperation {

        int operation(int a, int b);

    }

    interface GreetingService {
        void sayMessage(String message);
    }

}
