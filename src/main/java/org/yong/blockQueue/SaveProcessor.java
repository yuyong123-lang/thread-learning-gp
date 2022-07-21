package org.yong.blockQueue;

import com.sun.deploy.security.TrustRecorder;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yuys
 * @date 2022-07-21
 * @description 保存数据
 */
public class SaveProcessor extends Thread implements RequestProcessor {

    RequestProcessor nextProcessor;

    BlockingQueue<Request> requests = new LinkedBlockingQueue();

    boolean finished;

    public SaveProcessor(RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void processRequest(Request request) {
        requests.add(request);
    }

    @Override
    public void run() {
        while (!finished && !Thread.currentThread().isInterrupted()) {
            try {
                Request request = requests.take();
                System.out.println("Save:" + request);
                nextProcessor.processRequest(request);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void shutdown() {
        System.out.println("SaveProcessor begin shutdown");
        finished = true;
        requests.clear();
        nextProcessor.shutdown();
        this.interrupt();
    }
}
