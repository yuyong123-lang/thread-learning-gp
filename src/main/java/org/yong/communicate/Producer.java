package org.yong.communicate;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author yuys
 * @date 2022-07-20
 * @description 生产者
 */
public class Producer implements Runnable {

    private Queue<String> messages;

    private int maxSize;

    private Lock lock;

    private Condition condition;

    public Producer(Queue<String> messages, int maxSize, Lock lock, Condition condition) {
        this.messages = messages;
        this.maxSize = maxSize;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            i++;
            lock.lock();
            while (messages.size() == maxSize) {
                System.out.println("生产者, 队列已满, 请等待！！");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("生产者生产了message" + i);
            messages.add("消息" + i);
            condition.signal();
            lock.unlock();
        }
    }
}
