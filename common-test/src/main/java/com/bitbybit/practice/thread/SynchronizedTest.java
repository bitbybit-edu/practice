package com.bitbybit.practice.thread;

import java.util.logging.Logger;

/**
 * 多线程的同步机制对资源进行加锁，使得在同一个时间，只有一个线程可以进行操作，同步用以解决多个线程同时访问时可能出现的问题。
 * <p>
 * 　　同步机制可以使用synchronized关键字实现。
 * <p>
 * 　　当synchronized关键字修饰一个方法的时候，该方法叫做同步方法。
 * <p>
 * 　　当synchronized方法执行完或发生异常时，会自动释放锁。
 *
 * @author liulin
 * @date 2020/4/22
 */
public class SynchronizedTest {

    public static void main(String[] args) {
//        a();
//        b();
//        c();
//        d();
//        e();
        f();
    }

    private static void f() {
        ExampleF exampleF = new ExampleF();
        new Thread(() -> {
            exampleF.execute();
        }, "线程1").start();
        new Thread(() -> {
            exampleF.execute();
        }, "线程2").start();
        new Thread(() -> {
            exampleF.execute2();
        }, "线程3").start();
        new Thread(() -> {
            exampleF.execute2();
        }, "线程4").start();

    }


    private static void e() {
        ExampleE exampleE = new ExampleE();
        new Thread(() -> {
            exampleE.execute();
        }, "线程1").start();
        new Thread(() -> {
            exampleE.execute2();
        }, "线程2").start();
    }

    /**
     * 没有任何同步
     */
    public static void a() {
        Example example = new Example();
        new Thread(() -> {
            example.execute();
        }, "线程1").start();
        new Thread(() -> {
            example.execute();
        }, "线程2").start();
    }

    /**
     * 1.是否使用synchronized关键字的不同
     * 是否在execute()方法前加上synchronized关键字，这个例子程序的执行结果会有很大的不同。
     * <p>
     * 　　如果不加synchronized关键字，则两个线程同时执行execute()方法，输出是两组并发的。
     * <p>
     * 　　如果加上synchronized关键字，则会先输出一组0到9，然后再输出下一组，说明两个线程是顺次执行的。
     */
    public static void b() {
        ExampleB exampleB = new ExampleB();
        new Thread(() -> {
            exampleB.execute();
        }, "线程1").start();
        new Thread(() -> {
            exampleB.execute();
        }, "线程2").start();
    }

    /**
     * 2.多个方法的多线程情况
     * <p>
     * 如果去掉synchronized关键字，则两个方法并发执行，并没有相互影响。
     * <p>
     * 　　但是如例子程序中所写，即便是两个方法：
     * <p>
     * 　　执行结果永远是执行完一个线程的输出再执行另一个线程的。
     * <p>
     * 　　说明：
     * <p>
     * 　　如果一个对象有多个synchronized方法，某一时刻某个线程已经进入到了某个synchronized方法，那么在该方法没有执行完毕前，其他线程是无法访问该对象的任何synchronized方法的。
     * <p>
     * 　　结论：
     * <p>
     * 　　当synchronized关键字修饰一个方法的时候，该方法叫做同步方法。
     * <p>
     * 　　Java中的每个对象都有一个锁（lock），或者叫做监视器（monitor），当一个线程访问某个对象的synchronized方法时，将该对象上锁，其他任何线程都无法再去访问该对象的synchronized方法了（这里是指所有的同步方法，而不仅仅是同一个方法），直到之前的那个线程执行方法完毕后（或者是抛出了异常），才将该对象的锁释放掉，其他线程才有可能再去访问该对象的synchronized方法。
     * <p>
     * 　　注意这时候是给对象上锁，如果是不同的对象，则各个对象之间没有限制关系。
     * <p>
     * 　　尝试在代码中构造第二个线程对象时传入一个新的Example对象，则两个线程的执行之间没有什么制约关系。
     */
    public static void c() {
        ExampleC exampleC = new ExampleC();
        new Thread(() -> {
            exampleC.execute();
        }, "线程1").start();
        new Thread(() -> {
            exampleC.execute2();
        }, "线程2").start();
    }

    /**
     * 所以如果是静态方法的情况（execute()和execute2()都加上static关键字），即便是向两个线程传入不同的Example对象，这两个线程仍然是互相制约的，必须先执行完一个，再执行下一个。
     * <p>
     * <p>
     * <p>
     * 　　结论：
     * <p>
     * 　　如果某个synchronized方法是static的，那么当线程访问该方法时，它锁的并不是synchronized方法所在的对象，而是synchronized方法所在的类所对应的Class对象。Java中，无论一个类有多少个对象，这些对象会对应唯一一个Class对象，因此当线程分别访问同一个类的两个对象的两个static，synchronized方法时，它们的执行顺序也是顺序的，也就是说一个线程先去执行方法，执行完毕后另一个线程才开始。
     */
    public static void d() {
        new Thread(() -> {
            ExampleD.execute();
        }, "线程1").start();
        new Thread(() -> {
            ExampleD.execute2();
        }, "线程2").start();
    }

}

/**
 * 没有同步方法
 */
class Example {
    Logger logger = Logger.getLogger("com.bitbybit.practice.thread.Example");
    private Integer total = 200;
    public void execute() {
        for (int i = 0; i < 10; i++) {
            try {
                logger.info("thread = " + Thread.currentThread().getName() + ", i = " + i);
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 同步方法
 */
class ExampleB {
    Logger logger = Logger.getLogger("com.bitbybit.practice.thread.ExampleB");

    public synchronized void execute() {
        for (int i = 0; i < 10; i++) {
            try {
                logger.info("thread = " + Thread.currentThread().getName() + ", i = " + i);
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 两个同步方法
 */
class ExampleC {
    Logger logger = Logger.getLogger("com.bitbybit.practice.thread.ExampleC");

    public synchronized void execute() {
        for (int i = 0; i < 10; i++) {
            try {
                logger.info("thread = " + Thread.currentThread().getName() + ", execute()" + ", i = " + i);
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void execute2() {
        for (int i = 0; i < 10; i++) {
            try {
                logger.info("thread = " + Thread.currentThread().getName() + ", execute2()" + ", i = " + i);
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 静态同步方法
 */
class ExampleD {
    static Logger logger = Logger.getLogger("com.bitbybit.practice.thread.ExampleD");

    public static synchronized void execute() {
        for (int i = 0; i < 10; i++) {
            try {
                logger.info("thread = " + Thread.currentThread().getName() + ", i = " + i);
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void execute2() {
        for (int i = 0; i < 10; i++) {
            try {
                logger.info("thread = " + Thread.currentThread().getName() + ", i = " + i);
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 同步代码块
 */
class ExampleE {

    static Logger logger = Logger.getLogger("com.bitbybit.practice.thread.ExampleE");

    public void execute() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {

                try {
                    logger.info("thread = " + Thread.currentThread().getName() + ", i = " + i);
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void execute2() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {

                try {
                    logger.info("thread = " + Thread.currentThread().getName() + ", i = " + i);
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

/**
 * 同步代码块
 */
class ExampleF {

    static Logger logger = Logger.getLogger("com.bitbybit.practice.thread.ExampleF");

    private Integer num = 100;

    private Integer num2 = 100;

    public void execute() {
        logger.info("thread = " + Thread.currentThread().getName() + ", num = " + num);
        synchronized (num) {
            while (num > 0) {

                try {
                    Thread.sleep((long) (Math.random() * 50));
                    num = num - 1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("thread = " + Thread.currentThread().getName() + ", num = " + num);
            }
        }


    }

    public synchronized void execute2() {
        logger.info("thread = " + Thread.currentThread().getName() + ", num = " + num);
        synchronized (num) {
            while (num > 0) {

                try {
                    Thread.sleep((long) (Math.random() * 50));
                    num = num - 1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("thread = " + Thread.currentThread().getName() + ", num = " + num);
            }
        }

    }
}