package com.bitbybit.practice.thread;

import java.util.Random;

public class RunnableTestDemo {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable("线程１");
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
    }

}

class MyRunnable implements Runnable {
    private Integer total = 300;

    private String threadId;

    MyRunnable(String threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        while (total > 0) {
            total = total - 1;

            try {
                Thread.sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "=========" + total);
        }
    }


}