package com.bitbybit.practice.collection;

import java.util.LinkedList;

public class LinkedListPractice {

    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<Integer>();
        for (int i = 0; i < 100; i++) {
            integers.add(Integer.valueOf(i));
        }
    }
}
