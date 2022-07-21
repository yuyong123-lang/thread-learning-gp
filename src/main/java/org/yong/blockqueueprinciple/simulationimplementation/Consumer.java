package org.yong.blockqueueprinciple.simulationimplementation;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author yuys
 * @date 2022-07-21
 * @description 消费者
 */
public class Consumer implements Runnable {

    private Lock lock;

    private Condition notEmpty;

    private Condition notFull;

    private List<String> messageQueues;

    private int maxSize;

    public Consumer(Lock lock, Condition notEmpty, Condition notFull, List<String> messageQueues, int maxSize) {
        this.lock = lock;
        this.notEmpty = notEmpty;
        this.notFull = notFull;
        this.messageQueues = messageQueues;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            while (messageQueues.size() == 0) {
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 消费者消费消息
            System.out.println("消费者消费消息" + messageQueues.remove(0));
            notFull.signal();
            lock.lock();
        }
    }
}
