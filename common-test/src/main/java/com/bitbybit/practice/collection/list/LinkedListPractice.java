package com.bitbybit.practice.collection.list;

import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * @author liulin
 */
public class LinkedListPractice {

    private final static Logger logger = Logger.getLogger(LinkedListPractice.class.getSimpleName());

    public static void main(String[] args) {
        int forCount = 10;
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        LinkedList<Integer> linkedListStack = new LinkedList<>();
        for (int i = 0; i < forCount; i++) {
            linkedList.add(i);
            linkedListStack.push(i);
        }
        logger.info(linkedList.toString());
        logger.info(linkedListStack.toString());

        for (int i = 0; i < forCount; i++) {
            Integer poll = linkedList.poll();
            logger.info("poll====" + poll);

            Integer pop = linkedListStack.pop();
            logger.info("pop====" + pop);
        }

    }


}
