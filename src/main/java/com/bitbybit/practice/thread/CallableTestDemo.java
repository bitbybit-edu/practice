package com.bitbybit.practice.thread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTestDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        String s = futureTask.get();
        System.out.println(s);
    }
}

class MyCallable<String> implements Callable<java.lang.String> {

    @Override
    public java.lang.String call() throws Exception {

        return "线程执行完成" + Thread.currentThread().getName();
    }
}


