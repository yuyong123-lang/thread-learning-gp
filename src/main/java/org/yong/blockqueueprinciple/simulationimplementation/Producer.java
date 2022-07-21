package org.yong.blockqueueprinciple.simulationimplementation;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author yuys
 * @date 2022-07-21
 * @description 生产者
 */
public class Producer implements Runnable {

    private Lock lock;

    private Condition notEmpty;

    private Condition notFull;

    private List<String> messageQueues;

    private int maxSize;

    public Producer(Lock lock, Condition notEmpty, Condition notFull, List<String> messageQueues, int maxSize) {
        this.lock = lock;
        this.notEmpty = notEmpty;
        this.notFull = notFull;
        this.messageQueues = messageQueues;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            lock.lock();
            while (maxSize == messageQueues.size()) {
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 生产者生产消息
            messageQueues.add("消息" + i);
            i++;
            System.out.println("生产者生产了消息" + i);
            notEmpty.signal();
            lock.lock();
        }
    }
}
