package org.yong.blockQueue;

import java.util.concurrent.TimeUnit;

/**
 * @author yuys
 * @date 2022-07-21
 * @description
 */
public class ProcessorServer {

    public void setServerUp() {
        RequestProcessor finalProcessor = new FinalProcessor();
        RequestProcessor saveProcessor = new SaveProcessor(finalProcessor);
        RequestProcessor printProcessor = new PrintProcessor(saveProcessor);

        ((FinalProcessor) finalProcessor).start();
        ((SaveProcessor) saveProcessor).start();
        ((PrintProcessor) printProcessor).start();

        printProcessor.processRequest(new Request("测试消费"));

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printProcessor.shutdown();
    }

    public void startUp() {
        setServerUp();
    }

    public static void main(String[] args) {
        new ProcessorServer().startUp();
    }
}
