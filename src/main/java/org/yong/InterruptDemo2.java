package org.yong;

import java.util.concurrent.TimeUnit;

/**
 * @author yuys
 * @date 2022-07-14
 * @description
 */
public class InterruptDemo2 implements Runnable {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                TimeUnit.SECONDS.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptDemo2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
