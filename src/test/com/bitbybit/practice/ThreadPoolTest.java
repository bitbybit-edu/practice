package com.bitbybit.practice;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadPoolTest {

    @Test
    public void threadPoolCreateTest() throws ExecutionException, InterruptedException {
        ThreadFactoryImpl threadFactory = new ThreadFactoryImpl("test");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1 << 2, 1 << 4, 5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1 << 2), threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());


        CallableImpl callable = new CallableImpl(1000L);
        Future<Long> submit1 = threadPoolExecutor.submit(callable);
        Future<Long> submit2 = threadPoolExecutor.submit(callable);
        Future<Long> submit3 = threadPoolExecutor.submit(callable);
        Future<Long> submit4 = threadPoolExecutor.submit(callable);
        Future<Long> submit5 = threadPoolExecutor.submit(callable);
        Future<Long> submit6 = threadPoolExecutor.submit(callable);
        Future<Long> submit7 = threadPoolExecutor.submit(callable);
//        threadPoolExecutor.shutdown();
//        System.out.println(submit1.get());
//        System.out.println(submit2.get());
//        System.out.println(submit3.get());
//        System.out.println(submit4.get());
//        System.out.println(submit5.get());
//        System.out.println(submit6.get());
        System.out.println(submit7.get());

    }

    class CallableImpl implements Callable<Long> {
        private Long total;

        CallableImpl(Long total) {
            this.total = total;
        }

        @Override
        public Long call() throws Exception {
            while (total > 0) {
                total--;
            }
            System.out.println("thread name : " + Thread.currentThread().getName() + "--- total : " + total);
            return total;
        }
    }

    class ThreadFactoryImpl implements ThreadFactory {

        private String poolName;

        AtomicLong num = new AtomicLong();

        public ThreadFactoryImpl(String poolName) {
            this.poolName = poolName;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName(poolName + "-" + String.valueOf(num.getAndIncrement()));
            return thread;
        }
    }
}