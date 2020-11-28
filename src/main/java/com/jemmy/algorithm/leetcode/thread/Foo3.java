package com.jemmy.algorithm.leetcode.thread;

import java.util.concurrent.TimeUnit;

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
public class Foo3 {

    // 方案3：使用 synchronized + object
    // 由于使用同一把锁，遵循 happens-before 原则，不需要加 volatile
    private boolean firstComplete = false;
    private boolean secondComplete = false;
    private Object obj = new Object();

    public Foo3() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (obj) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstComplete = true;
            // 这里必须是 notifyAll，notify 可能没通知到目标线程
            obj.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (obj) {
            while (!firstComplete) {
                obj.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondComplete = true;
            // 这里必须是 notifyAll，notify 可能没通知到目标线程
            obj.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (obj) {
            while (!secondComplete) {
                obj.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

}