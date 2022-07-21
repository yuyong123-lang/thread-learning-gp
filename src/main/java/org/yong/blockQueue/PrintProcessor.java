package org.yong.blockQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yuys
 * @date 2022-07-21
 * @description 打印数据
 */
public class PrintProcessor extends Thread implements RequestProcessor {

    // 终止标志
    volatile boolean finished;
    // 下一个处理器
    RequestProcessor nextProcessor;

    // 存储请求数据
    BlockingQueue<Request> requests = new LinkedBlockingQueue<>();

    public PrintProcessor(RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void processRequest(Request request) {
        requests.add(request); // 生产消息
    }

    @Override
    public void run() {
        while (!finished && !Thread.currentThread().isInterrupted()) {
            try {
                Request request = requests.take();
                System.out.println("Print :" + request);
                nextProcessor.processRequest(request);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void shutdown() {
        System.out.println("PrintProcessor begin shutdown");
        finished = true;
        requests.clear();
        nextProcessor.shutdown();
        this.interrupt();
    }
}
