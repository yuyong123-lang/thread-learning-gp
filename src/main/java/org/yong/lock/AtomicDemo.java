package org.yong.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuys
 * @date 2022-07-19
 * @description
 */
public class AtomicDemo {

    private static int count = 0;
    // 互斥锁 可重入锁
    static Lock lock = new ReentrantLock();

    public static void inc() {
        lock.lock();
        try {
            Thread.sleep(1);
            count++;
            decr();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void decr() {
        lock.lock();
        try {
            Thread.sleep(1);
            count--;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> AtomicDemo.inc()).start();
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result:" + count);
    }

}
