package com.bitbybit.practice.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 *
 * @author liulin
 * @date 2020/4/24
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        int corePoolSize = 1;
        int maximumPoolSize = 2;
        long keepAliveTime = 10L;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(6);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
                timeUnit, arrayBlockingQueue, new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.execute(() -> {
            try {
                System.out.println(Thread.currentThread().getId() + "正在执行");
                long sleep = 20 * 1000L;
                Thread.sleep(sleep);
                System.out.println(Thread.currentThread().getId() + ":sleep=" + sleep + "执行完成");
            } catch (Exception e) {

            }
        });

        threadPoolExecutor.execute(() -> {
            try {
                System.out.println(Thread.currentThread().getId() + "正在执行");
                long sleep = 20 * 1000L;
                Thread.sleep(sleep);
                System.out.println(Thread.currentThread().getId() + ":sleep=" + sleep + "执行完成");
            } catch (Exception e) {

            }
        });
        threadPoolExecutor.execute(() -> {
            try {
                System.out.println(Thread.currentThread().getId() + "正在执行");
                long sleep = 20 * 1000L;
                Thread.sleep(sleep);
                System.out.println(Thread.currentThread().getId() + ":sleep=" + sleep + "执行完成");
            } catch (Exception e) {

            }
        });

        threadPoolExecutor.execute(() -> {
            try {
                System.out.println(Thread.currentThread().getId() + "正在执行");
                long sleep = 20 * 1000L;
                Thread.sleep(sleep);
                System.out.println(Thread.currentThread().getId() + ":sleep=" + sleep + "执行完成");
            } catch (Exception e) {

            }
        });

        threadPoolExecutor.execute(() -> {
            try {
                System.out.println(Thread.currentThread().getId() + "正在执行");
                long sleep = 20 * 1000L;
                Thread.sleep(sleep);
                System.out.println(Thread.currentThread().getId() + ":sleep=" + sleep + "执行完成");
            } catch (Exception e) {

            }
        });

        threadPoolExecutor.shutdown();

//        threadPoolExecutor.execute(() -> {
//            try {
//                System.out.println(Thread.currentThread().getId() + "正在执行");
//                long sleep = 20 * 1000L;
//                Thread.sleep(sleep);
//                System.out.println(Thread.currentThread().getId() + ":sleep=" + sleep + "执行完成");
//            } catch (Exception e) {
//
//            }
//        });

    }
}
