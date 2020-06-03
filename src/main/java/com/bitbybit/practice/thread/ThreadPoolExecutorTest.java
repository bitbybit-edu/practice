package com.bitbybit.practice.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池
 *
 * @author liulin
 * @date 2020/4/24
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        int corePoolSize = 2;
        int maximumPoolSize = 2;
        long keepAliveTime = 10L;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(2);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
                timeUnit, arrayBlockingQueue, new CustomThreadFactory("测试线程池"), new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.execute(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "正在执行");
                long sleep = 20 * 1000L;
                Thread.sleep(sleep);
                System.out.println(Thread.currentThread().getName() + ":sleep=" + sleep + "执行完成");
            } catch (Exception e) {

            }
        });

        threadPoolExecutor.execute(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "正在执行");
                long sleep = 20 * 1000L;
                Thread.sleep(sleep);
                System.out.println(Thread.currentThread().getName() + ":sleep=" + sleep + "执行完成");
            } catch (Exception e) {

            }
        });
        threadPoolExecutor.execute(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "正在执行");
                long sleep = 20 * 1000L;
                Thread.sleep(sleep);
                System.out.println(Thread.currentThread().getName() + ":sleep=" + sleep + "执行完成");
            } catch (Exception e) {

            }
        });

        threadPoolExecutor.execute(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "正在执行");
                long sleep = 20 * 1000L;
                Thread.sleep(sleep);
                System.out.println(Thread.currentThread().getName() + ":sleep=" + sleep + "执行完成");
            } catch (Exception e) {

            }
        });

        threadPoolExecutor.execute(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "正在执行");
                long sleep = 20 * 1000L;
                Thread.sleep(sleep);
                System.out.println(Thread.currentThread().getName() + ":sleep=" + sleep + "执行完成");
            } catch (Exception e) {

            }
        });

        threadPoolExecutor.shutdown();
        System.out.println("tingzhi");

    }

    /**
     * 自定义线程factory
     */
    static class CustomThreadFactory implements ThreadFactory {
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        CustomThreadFactory(String poolName) {
            namePrefix = poolName + "-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(null, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);

            return t;
        }
    }
}
