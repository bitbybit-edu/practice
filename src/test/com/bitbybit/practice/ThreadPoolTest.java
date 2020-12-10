package com.bitbybit.practice;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadPoolTest {

    @Test
    public void threadPoolCreateTest() throws ExecutionException, InterruptedException {
            ThreadFactoryImpl threadFactory = new ThreadFactoryImpl("test");
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1 << 1, 1 << 4, 5, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(1 << 1), threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());


            CallableImpl callable = new CallableImpl(100L);
            Future<Long> submit1 = threadPoolExecutor.submit(callable);
            Future<Long> submit2 = threadPoolExecutor.submit(callable);
            Future<Long> submit3 = threadPoolExecutor.submit(callable);
            Future<Long> submit4 = threadPoolExecutor.submit(callable);
            Future<Long> submit5 = threadPoolExecutor.submit(callable);
            Future<Long> submit6 = threadPoolExecutor.submit(callable);
            Future<Long> submit7 = threadPoolExecutor.submit(callable);
            Future<Long> submit8 = threadPoolExecutor.submit(callable);
            Future<Long> submit9 = threadPoolExecutor.submit(callable);
            Future<Long> submit10 = threadPoolExecutor.submit(callable);
    //        Future<Long> submit11 = threadPoolExecutor.submit(callable);
    //        Future<Long> submit12 = threadPoolExecutor.submit(callable);
    //        Future<Long> submit13 = threadPoolExecutor.submit(callable);
    //        Future<Long> submit14 = threadPoolExecutor.submit(callable);
    //        Future<Long> submit15 = threadPoolExecutor.submit(callable);
            Thread daemonThread = new Thread(new DaemonRunnable(threadPoolExecutor));
            daemonThread.setDaemon(Boolean.TRUE);
            daemonThread.start();

            System.out.println(submit1.get());
            System.out.println(submit2.get());
            System.out.println(submit3.get());
            System.out.println(submit4.get());
            System.out.println(submit5.get());
            System.out.println(submit6.get());
            System.out.println(submit7.get());
            System.out.println(submit8.get());

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadPoolExecutor.shutdown();
    }

    class DaemonRunnable implements Runnable {
        private ThreadPoolExecutor threadPoolExecutor;

        public DaemonRunnable(ThreadPoolExecutor threadPoolExecutor) {
            this.threadPoolExecutor = threadPoolExecutor;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int activeCount = threadPoolExecutor.getActiveCount();
                long taskCount = threadPoolExecutor.getTaskCount();
                long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
                System.out.println("activeCount : " + activeCount + "---taskCount : " + taskCount + "---completedTaskCount : " + completedTaskCount);
            }

        }
    }

    class CallableImpl implements Callable<Long> {
        private Long total;

        CallableImpl(Long total) {
            this.total = total;
        }

        @Override
        public Long call() {
            while (total > 0) {
                Random random = new Random();
                long l = random.nextInt(2000);
                try {
                    Thread.sleep(l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                total--;
                System.out.println("random : " + l + "---thread name : " + Thread.currentThread().getName() + "--- total : " + total);
            }
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
