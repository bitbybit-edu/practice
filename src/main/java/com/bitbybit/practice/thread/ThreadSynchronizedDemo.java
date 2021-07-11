package com.bitbybit.practice.thread;

public class ThreadSynchronizedDemo {

    public static void main(String[] args) {
        TicketRunnable ticketRunnable = new TicketRunnable();
        new Thread(ticketRunnable, "线程1").start();
        new Thread(ticketRunnable, "线程2").start();
        new Thread(ticketRunnable, "线程3").start();
    }
}

class TicketRunnable implements Runnable {

    private volatile int ticket = 10;

    @Override
    public void run() {
        while (true) {
            String name = Thread.currentThread().getName();
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + "抢到票了,ticket = " + ticket--);
            } else {
                System.out.println( name + "票没了");
                break;
            }
        }
    }

}
