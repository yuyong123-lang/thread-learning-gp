package org.yong.communicate;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuys
 * @date 2022-07-20
 * @description
 */
public class Test {

    public static void main(String[] args) {
        Queue<String> messages = new LinkedList<>();
        int maxSize = 5;
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        Producer producer = new Producer(messages, maxSize, reentrantLock, condition);
        Consumer consumer = new Consumer(messages, maxSize, reentrantLock, condition);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
