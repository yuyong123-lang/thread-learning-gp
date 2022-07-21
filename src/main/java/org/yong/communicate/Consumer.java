package org.yong.communicate;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author yuys
 * @date 2022-07-20
 * @description
 */
public class Consumer implements Runnable {

    private Queue<String> messages;

    private int maxSize;

    private Lock lock;

    private Condition condition;

    public Consumer(Queue<String> messages, int maxSize, Lock lock, Condition condition) {
        this.messages = messages;
        this.maxSize = maxSize;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {

        while (true) {
            lock.lock();
            while (messages.isEmpty()) {
                System.out.println("消费者， 队列为空无法消费");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("消费者消费了" + messages.remove());
            condition.signal();
            lock.unlock();
        }
    }
}
