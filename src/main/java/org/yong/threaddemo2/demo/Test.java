package org.yong.threaddemo2.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuys
 * @date 2022-07-16
 * @description
 */
public class Test {

    public static void main(String[] args) {
        Queue<String> msgs = new LinkedList<>();
        int maxSize = 5;
        Product product = new Product(msgs, maxSize);
        Consumer consumer = new Consumer(msgs, maxSize);

        new Thread(product).start();
        new Thread(consumer).start();
    }
}
