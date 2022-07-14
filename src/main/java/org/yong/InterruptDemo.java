package org.yong;

import java.util.concurrent.TimeUnit;

/**
 * @author yuys
 * @date 2022-07-14
 * @description
 */
public class InterruptDemo implements Runnable {

    private int i = 1;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("test" + i++);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new InterruptDemo());
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
