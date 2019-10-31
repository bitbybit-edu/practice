package com.bitbybit.practice.queue;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.logging.Logger;

/**
 * 优先级队列练习
 *
 * @author liulin
 */
public class PriorityQueuePractice {

    private static final Logger logger = Logger.getLogger(PriorityQueuePractice.class.getSimpleName());

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(100);
        int forCount = 100;
        for (int i = forCount; i > 0; i--) {
            priorityQueue.add(i);
        }

        logger.info(priorityQueue.toString());

        PriorityQueue<Integer> priorityQueueCopy = new PriorityQueue<>(priorityQueue);
        logger.info(priorityQueueCopy.toString());
        forCount += 10;
        for (int i = forCount; i > 0; i--) {
            Integer poll = priorityQueueCopy.poll();
            if (Objects.isNull(poll)) {
                logger.info("队列中没有元素");
                break;
            }
            logger.info(String.valueOf(poll));
        }

    }

}
