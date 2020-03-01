package com.bitbybit.practice.thread;

public class ThreadYieldDemo {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread threadFirst = new Thread(myRunnable, "线程１");
        threadFirst.start();

        MyRunnable myRunnable1 = new MyRunnable();
        myRunnable1.setBrotherThread(threadFirst);
        Thread threadSecond = new Thread(myRunnable1, "线程２");
        threadSecond.start();


    }
}
