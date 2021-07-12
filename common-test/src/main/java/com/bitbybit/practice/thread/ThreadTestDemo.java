package com.bitbybit.practice.thread;

import java.util.Random;

public class ThreadTestDemo {

    public static void main(String[] args) {
        new MyThread("线程1").start();
        new MyThread("线程2").start();
        new MyThread("线程3").start();
    }

}

class MyThread extends Thread {

    private String threadId;

    MyThread(String threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(threadId + "开始执行＝＝＝＝" + i);
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadId + "结束执行＝＝＝＝" + i);
        }
    }
}