package org.yong.threaddemo3;

/**
 * @author yuys
 * @date 2022-07-17
 * @description
 */
public class VolatileDemo {

    //    public volatile static boolean flag = true;
    private static volatile Person person;

    public static void setDemo() {
        person = new Person();
        person.setName("yuys");
    }

    public static void main(String[] args) {
        new Thread(() -> {
            Thread.interrupted();
        }).start();
    }
}
