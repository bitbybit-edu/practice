package com.bitbybit.practice.thread;

import java.util.Objects;

public class MyRunnable implements Runnable {

    private Thread brotherThread;

    public Thread getBrotherThread() {
        return brotherThread;
    }

    public void setBrotherThread(Thread brotherThread) {
        this.brotherThread = brotherThread;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Thread thread = Thread.currentThread();

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (i > 3 && !Objects.isNull(brotherThread)) {
                Thread.yield();
//                try {
//                    brotherThread.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

            System.out.println("线程" + thread.getName() + "执行中:x======" + i);
        }
    }

}
