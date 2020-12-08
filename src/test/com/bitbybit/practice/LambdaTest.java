package com.bitbybit.practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaTest {

    static class Simple {
        private String simple;

        public Simple() {

        }

        public Simple(String simple) {
            this.simple = simple;
        }

        @Override
        public String toString() {
            return "Simple{" +
                    "simple='" + simple + '\'' +
                    '}';
        }
    }

    static List<Simple> simples = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i ++){
            simples.add(new Simple(String.valueOf(i)));
        }
    }

    @Test
    public void print() {
        int c = 1;
        MathOperation add = (a, b) -> a + b + c;
        System.out.println(add.operation(1, 1));
    }

    @Test
    public void listStreamTest() {
        List<Simple> collect = simples.stream().filter(simple -> !simple.simple.equals("1")).collect(Collectors.toList());
        collect.forEach(System.out::println);

        Map<String, Simple> collect1 = collect.stream().collect(Collectors.toMap(s -> s.simple, v -> v));
        collect1.forEach((k,v) -> System.out.println(k + "," + v));

    }

    interface MathOperation {

        int operation(int a, int b);

    }

    interface GreetingService {
        void sayMessage(String message);
        void sayMessage2(String message, String a);
    }

}
