package com.bitbybit.practice.queue;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.logging.Logger;

/**
 * 优先级队列练习
 *
 * @author liulin
 */
public class PriorityQueuePractice {

    private static final Logger logger = Logger.getLogger(PriorityQueuePractice.class.getSimpleName());

    public static void main(String[] args) {
        int forCount = 1 << 3;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(forCount);

        int bound = 100;
        Random random = new Random(47);
        for (int i = forCount; i > 0; i--) {
            int element = random.nextInt(bound);
            priorityQueue.add(element);
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

//    private void siftDownComparable(int k, E x) {
//        Comparable<? super E> key = (Comparable<? super E>)x;
//        int half = size >>> 1;
//        while (k < half) { //假如下标k的元素存在左节点，则2k+1<=size,所以有k < size>>>1
//            int child = (k << 1) + 1; //计算左节点下标
//            Object c = queue[child];
//            int right = child + 1;//计算右节点下标
//            //如果左节点的值小于右节点则将c置为右节点的值，即c表示子节点中最小的值
//            if (right < size && //表示存在右节点
//                    ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
//                c = queue[child = right];
//            //如果父节点小于或者等于最小的子节点，则终止循环
//            if (key.compareTo((E) c) <= 0)
//                break;
//            //交换key和最小子节点的位置，继续往下比较子节点
//            queue[k] = c;
//            k = child;
//        }
//        queue[k] = key;
//    }

}
