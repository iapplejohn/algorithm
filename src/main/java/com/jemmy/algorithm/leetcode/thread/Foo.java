package com.jemmy.algorithm.leetcode.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1114. 按序打印
 *
 * 我们提供了一个类：
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用 second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: "firstsecondthird"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
 * 正确的输出是 "firstsecondthird"。
 * 示例 2:
 *
 * 输入: [1,3,2]
 * 输出: "firstsecondthird"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。
 * 正确的输出是 "firstsecondthird"。
 *  
 *
 * 提示：
 *
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * 你看到的输入格式主要是为了确保测试的全面性。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhujiang.cheng
 * @since 2020/11/28
 */
public class Foo {

    // 方案1：使用可重入锁的Condition

    private ReentrantLock lock;
    // 条件信号 - 第一个线程是否执行
    private Condition firstRun;
    // 条件信号 - 第二个线程是否执行
    private Condition secondRun;
    // 状态，因为信号可能会丢失
    private int num;

    public Foo() {
        num = 1;
        lock = new ReentrantLock();
        firstRun = lock.newCondition();
        secondRun = lock.newCondition();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        lock.lock();
        try {
            printFirst.run();
            num = 2;
            firstRun.signal();
            System.out.println(Thread.currentThread().getName() + " first after signal");
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " first after unlock");
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " second before lock");
        lock.lock();
        try {
            while (num != 2) {
                System.out.println(Thread.currentThread().getName() + " second before await");
                firstRun.await();
                System.out.println(Thread.currentThread().getName() + " second after await");
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            num = 3;
            secondRun.signal();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " third before lock");
        lock.lock();
        try {
            while (num != 3) {
                System.out.println(Thread.currentThread().getName() + " third before await");
                secondRun.await();
                System.out.println(Thread.currentThread().getName() + " third after await");
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            num = 1;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        Runnable printFirst = new Runnable() {
            @Override
            public void run() {
                System.out.println("first");
            }
        };

        Runnable printSecond = new Runnable() {
            @Override
            public void run() {
                System.out.println("second");
            }
        };

        Runnable printThird = new Runnable() {
            @Override
            public void run() {
                System.out.println("third");
            }
        };

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(printFirst);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second(printSecond);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(printThird);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t2.start();
        t3.start();
        t1.start();
    }
}
