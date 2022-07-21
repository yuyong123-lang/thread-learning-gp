package org.yong.blockqueueprinciple.concurrentutils;

import java.util.concurrent.CountDownLatch;

/**
 * @author yuys
 * @date 2022-07-21
 * @description
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            System.out.println("线程执行前");
            countDownLatch.countDown();
            System.out.println("线程执行后");
        }).start();

        new Thread(() -> {
            System.out.println("线程执行前");
            countDownLatch.countDown();
            System.out.println("线程执行后");
        }).start();

        countDownLatch.await();
    }
}
