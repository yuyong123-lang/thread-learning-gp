package org.yong.blockqueueprinciple.simulationimplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuys
 * @date 2022-07-21
 * @description
 */
public class SimulationImplementation {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition notEmpty = lock.newCondition();
        Condition notFull = lock.newCondition();
        List<String> messageQueues = new ArrayList<>();
        int maxSize = 5;

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Consumer(lock, notEmpty, notFull, messageQueues, maxSize));
        executorService.execute(new Consumer(lock, notEmpty, notFull, messageQueues, maxSize));
        executorService.execute(new Consumer(lock, notEmpty, notFull, messageQueues, maxSize));
        executorService.execute(new Producer(lock, notEmpty, notFull, messageQueues, maxSize));
    }
}
