package org.yong.threaddemo1;

import java.util.concurrent.*;

/**
 * @author yuys
 * @date 2022-07-14
 * @description
 */
public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("come in");
        return "Success";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(new CallableDemo());
//        String s = future.get();
//        System.out.println(s);
        System.out.println("main thread");
    }
}
