package org.yong.threaddemo2;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * @author yuys
 * @date 2022-07-16
 * @description
 */
public class SynchronizedDemo {

    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        System.out.println(ClassLayout.parseInstance(synchronizedDemo).toPrintable());

        /*try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t1 = new Thread(() -> {
            synchronized (synchronizedDemo) {
                System.out.println("t1, 抢占锁");
                System.out.println(ClassLayout.parseInstance(synchronizedDemo).toPrintable());
            }
        }, "t1");
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (synchronizedDemo) {
            System.out.println(ClassLayout.parseInstance(synchronizedDemo).toPrintable());
        }*/
    }
}
/**
 * 大端存储和小端存储
 * 00 00 00 00 00 00 00 01
 * <p>
 * 00000000 00000000 00000000 00000000
 * 00000000 00000000 00000000 00000001
 */

