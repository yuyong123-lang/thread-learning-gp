package org.yong.blockqueueprinciple.concurrentutils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author yuys
 * @date 2022-07-21
 * @description 可以控制 很多个线程并发
 */
public class CountDownLatchDemo2 implements Runnable {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "   执行之前");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "   执行之后");
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(new CountDownLatchDemo2()).start();
        }
        TimeUnit.SECONDS.sleep(5);
        countDownLatch.countDown();
    }
}
