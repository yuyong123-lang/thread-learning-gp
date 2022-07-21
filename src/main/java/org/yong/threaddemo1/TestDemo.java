package org.yong.threaddemo1;

import java.util.concurrent.TimeUnit;

/**
 * @author yuys
 * @date 2022-07-14
 * @description
 */
public class TestDemo extends Thread {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Come In");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        testDemo.start();
        System.out.println("Main Thread");
    }
}
