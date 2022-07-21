package org.yong.threaddemo2;

/**
 * @author yuys
 * @date 2022-07-16
 * @description
 */
public class App {

    public static volatile int count = 0;

    public static void incr() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> App.incr()).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
