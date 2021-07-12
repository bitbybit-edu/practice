package com.bitbybit.practice.thread;

public class NumCalculationDemo {
    public static void main(String[] args) {
        Resource resource = new Resource();
        AddRunnable addRunnable = new AddRunnable(resource);
        SubRunnable subRunnable = new SubRunnable(resource);
        new Thread(addRunnable, "加法线程1").start();
        new Thread(addRunnable, "加法线程2").start();
        new Thread(subRunnable, "减法线程1").start();
        new Thread(subRunnable, "减法线程2").start();
    }
}

class Resource {
    private int num;

    /**
     * true: 可以加　　但不能减
     * false: 可以减　　但不能加
     */
    private boolean flag = true;

    public synchronized void add() throws Exception {
        while (!this.flag) {
            super.wait();
        }
        this.num++;
        Thread.sleep(100);
        System.out.println("[加法操作]----" + Thread.currentThread().getName() + "----num = " + this.num);
        this.flag = false;
        super.notifyAll();
    }

    public synchronized void sub() throws Exception {
        while (this.flag) {
            super.wait();
        }
        this.num--;
        Thread.sleep(200);
        System.out.println("[减法操作]----" + Thread.currentThread().getName() + "----num = " + this.num);
        this.flag = true;
        super.notifyAll();
    }
}

class AddRunnable implements Runnable {

    private Resource resource;

    public AddRunnable(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                this.resource.add();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class SubRunnable implements Runnable {

    private Resource resource;

    public SubRunnable(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                this.resource.sub();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}