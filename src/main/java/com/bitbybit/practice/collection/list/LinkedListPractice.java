package com.bitbybit.practice.collection.list;

import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * @author liulin
 */
public class LinkedListPractice {

    private final static Logger logger = Logger.getLogger(LinkedListPractice.class.getSimpleName());

    public static void main(String[] args) {
        int forCount = 100;
        LinkedList<Integer> integers = new LinkedList<Integer>();
        for (int i = 0; i < forCount; i++) {
            integers.add(i);
        }

        logger.info(integers.toString());
    }


}
