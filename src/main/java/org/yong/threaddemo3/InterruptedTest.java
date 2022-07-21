package org.yong.threaddemo3;

import java.util.concurrent.TimeUnit;

/**
 * @author yuys
 * @date 2022-07-18
 * @description 测试中断
 */
public class InterruptedTest extends Thread {

    @Override
    public void run() {
        boolean interrupted = false;
        while (!Thread.interrupted()) {
            try {
                System.out.println("正在睡眠中。。。");
                TimeUnit.SECONDS.sleep(10000);
                interrupted = Thread.interrupted();
            } catch (InterruptedException e) {
                currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new InterruptedTest());
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
