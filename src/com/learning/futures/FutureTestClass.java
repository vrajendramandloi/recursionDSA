package com.learning.futures;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTestClass {
    public static void main(String[] args) {
        FutureTestClass c1 = new FutureTestClass();
        c1.executeDaemon();
        c1.executeFuture();

        System.out.println("Future Block Completed");
    }

    Future<String> future = null;

    public void executeFuture() {
        ExecutorService service = Executors.newFixedThreadPool(1);
        future = service.submit(new Task());
    }

    public void executeDaemon() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    String result = future.get();
                    System.out.println("result = "+result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Hello World";
    }
}
