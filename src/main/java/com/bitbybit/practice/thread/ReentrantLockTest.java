package com.bitbybit.practice.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
        final BlockingQueue<Runnable> blockingDeque = new ArrayBlockingQueue<>(1 << 4);
        final RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, timeUnit, blockingDeque, rejectedExecutionHandler);
//        a(threadPoolExecutor);
//        b(threadPoolExecutor);
        c(threadPoolExecutor);
    }

    private static void c(ThreadPoolExecutor threadPoolExecutor) {
        ResourceTryLock resourceTryLock = new ResourceTryLock();
        threadPoolExecutor.execute(() -> {
            resourceTryLock.sub();
        });

        threadPoolExecutor.execute(() -> {
            resourceTryLock.sub();
        });

        threadPoolExecutor.execute(() -> {
            resourceTryLock.sub();
        });

        threadPoolExecutor.execute(() -> {
            resourceTryLock.read();
        });

        threadPoolExecutor.shutdown();
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
            resourceCompete.read();
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

    private static final Logger logger = LogManager.getLogger(ResourceCompete.class);

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

    private static final Logger logger = LogManager.getLogger(ResourceCompeteLock.class);

    ReentrantLock lock = new ReentrantLock();

    private Integer total = 50;

    public void sub() {
        lock.lock();
        try {
            while (total > 0) {
                try {
                    Thread.sleep((long) (new Random().nextFloat() * 500));
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
    public void read() {

        while (total > 0) {
            logger.info("holdCount = " + lock.getHoldCount() + ",queueLength = " + lock.getQueueLength());
            logger.info("thread = " + Thread.currentThread().getName() + ", 读取操作： total = " + total);

            try {
                Thread.sleep((long) (new Random().nextFloat() * 500));
            } catch (Exception e) {

            }
        }

    }

}

class ResourceTryLock {

    private static final Logger logger = LogManager.getLogger(ResourceTryLock.class);

    ReentrantLock reentrantLock = new ReentrantLock();

    private Integer total = 10;

    public void sub() {
        String name = Thread.currentThread().getName();

        try {
            if (reentrantLock.tryLock(5L, TimeUnit.SECONDS)) {
                try {
                    while (total > 0) {
                        Thread.sleep((long) (new Random().nextFloat() * 5000));
                        total = total - 1;
                        logger.info("thread = {}, 减法操作：total = {}", name, total);
                    }
                } catch (Exception e) {

                } finally {
                    reentrantLock.unlock();
                }

            } else {
                logger.info("thread = {}, 未获取锁", name);
            }

        } catch (Exception e) {
            logger.error("thread = {}", name, e);
        }


    }

    /**
     * 无lock锁 读和写不竞争
     */
    public void read() {
        String name = Thread.currentThread().getName();
        while (total > 0) {
            logger.info("thread = {}, 读取操作： total = {}", name, total);

            try {
                Thread.sleep((long) (new Random().nextFloat() * 5000));
            } catch (Exception e) {

            }
        }

    }
}

