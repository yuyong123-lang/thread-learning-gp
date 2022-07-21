package org.yong.blockQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yuys
 * @date 2022-07-20
 * @description 阻塞队列
 */
public class Demo {
    static BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        blockingQueue.add("yuyong");
        boolean offer = blockingQueue.offer("yuyong2");
    }
}
