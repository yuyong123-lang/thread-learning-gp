package org.yong.blockQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yuys
 * @date 2022-07-21
 * @description 打印数据
 */
public class FinalProcessor extends Thread implements RequestProcessor {

    // 终止标志
    volatile boolean finished;

    // 存储请求数据
    BlockingQueue<Request> requests = new LinkedBlockingQueue<>();

    @Override
    public void processRequest(Request request) {
        requests.add(request);
    }

    @Override
    public void run() {
        while (!finished && !Thread.currentThread().isInterrupted()) {
            try {
                Request request = requests.take();
                System.out.println("Final :" + request);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void shutdown() {
        System.out.println("FinalProcessor begin shutdown");
        finished = true;
        requests.clear();
        this.interrupt();
    }
}
