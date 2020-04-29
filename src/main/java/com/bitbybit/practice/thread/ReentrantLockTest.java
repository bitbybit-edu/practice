package com.bitbybit.practice.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * ReentrantLock 测试类
 *
 * @author liulin
 * @date 2020/4/29
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        final int corePoolSize = 1 << 3;
        final int maxPoolSize = Integer.MAX_VALUE;
        final long keepAliveTime = 0L;
        final TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        final BlockingQueue<Runnable> blockingDeque = new ArrayBlockingQueue<Runnable>(1 << 4);
        final RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, timeUnit, blockingDeque, rejectedExecutionHandler);
//        a(threadPoolExecutor);red
        b(threadPoolExecutor);
    }

    /**
     * @param threadPoolExecutor
     */
    private static void b(ThreadPoolExecutor threadPoolExecutor) {

        ResourceCompeteLock resourceCompete = new ResourceCompeteLock();
        threadPoolExecutor.execute(() -> {
            resourceCompete.sub();
        });

        threadPoolExecutor.execute(() -> {
            resourceCompete.sub();
        });

        threadPoolExecutor.execute(() -> {
            resourceCompete.sub();
        });

        threadPoolExecutor.execute(() -> {
            resourceCompete.sub();
        });

        threadPoolExecutor.execute(() -> {
            resourceCompete.sub();
        });

        threadPoolExecutor.execute(() -> {
            resourceCompete.red();
        });
        threadPoolExecutor.shutdown();
    }

    /**
     * 不带lock锁   减成负值
     *
     * @param threadPoolExecutor
     */
    private static void a(ThreadPoolExecutor threadPoolExecutor) {
        ResourceCompete resourceCompete = new ResourceCompete();
        threadPoolExecutor.execute(() -> {
            resourceCompete.sub();
        });

        threadPoolExecutor.execute(() -> {
            resourceCompete.sub();
        });

        threadPoolExecutor.execute(() -> {
            resourceCompete.sub();
        });

        threadPoolExecutor.execute(() -> {
            resourceCompete.sub();
        });

        threadPoolExecutor.execute(() -> {
            resourceCompete.sub();
        });

        threadPoolExecutor.shutdown();
    }

}

/**
 * 竞争资源  不带有Lock锁
 */
class ResourceCompete {

    private static final Logger logger = Logger.getLogger("com.bitbybit.practice.thread.Resource");

    Lock lock = new ReentrantLock();

    private Integer total = 200;

    public void sub() {

        while (total > 0) {
            try {
                Thread.sleep((long) (Math.random() * 200));
            } catch (Exception e) {

            }

            total = total - 1;
            logger.info("thread = " + Thread.currentThread().getName() + ", total = " + total);
        }

    }

}


class ResourceCompeteLock {

    private static final Logger logger = Logger.getLogger("com.bitbybit.practice.thread.Resource");

    Lock lock = new ReentrantLock();

    private Integer total = 50;

    public void sub() {
        lock.lock();
        try {
            while (total > 0) {
                try {
                    Thread.sleep((long) (Math.random() * 200));
                } catch (Exception e) {

                }

                total = total - 1;
                logger.info("thread = " + Thread.currentThread().getName() + ", 减法操作：total = " + total);
            }
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

    /**
     * 无lock锁 读和写不竞争
     */
    public void red() {

        while (total > 0) {
//            try {
//                Thread.sleep((long) (Math.random() * 200));
//            } catch (Exception e) {
//
//            }
            logger.info("thread = " + Thread.currentThread().getName() + ", 读取操作： total = " + total);
        }

    }

}

