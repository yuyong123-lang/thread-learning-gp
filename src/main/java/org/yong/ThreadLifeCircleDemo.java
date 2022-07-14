package org.yong;

import java.util.concurrent.TimeUnit;

/**
 * @author yuys
 * @date 2022-07-14
 * @description
 */
public class ThreadLifeCircleDemo {

    public static void main(String[] args) {

        Object o = new Object();
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                    Thread.yield();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "STATUS_01").start();

        new Thread(() -> {
            try {
                synchronized (ThreadLifeCircleDemo.class) {
                    System.out.println("唤醒waiting--before");
                    ThreadLifeCircleDemo.class.wait();
                    System.out.println("唤醒waiting-after");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "STATUS_02").start();


        new Thread(new BlockedDemo(), "BLOCKED_DEMO_01").start();
        new Thread(new BlockedDemo(), "BLOCKED_DEMO_02").start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (ThreadLifeCircleDemo.class) {
            ThreadLifeCircleDemo.class.notify();
        }
    }

    static class BlockedDemo extends Thread {
        @Override
        public void run() {
            synchronized (BlockedDemo.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
