package org.yong.threaddemo2.demo;

import java.util.Queue;

/**
 * @author yuys
 * @date 2022-07-16
 * @description
 */
public class Consumer implements Runnable {

    private Queue<String> msg;
    private int maxSize;

    public Consumer(Queue<String> msg, int maxSize) {
        this.msg = msg;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (msg) {
                while (msg.isEmpty()) {
                    try {
                        msg.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者消费信息：" + msg.remove());
                msg.notify();
            }
        }
    }
}
