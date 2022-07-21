package org.yong.blockqueueprinciple;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author yuys
 * @date 2022-07-21
 * @description Hello World
 */
public class Test {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        try {
            blockingQueue.put("yuyong");
            blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
