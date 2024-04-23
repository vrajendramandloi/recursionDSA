package com.learning.futures;

import java.util.concurrent.*;

public class CompletableFutureTest {
    public static void main(String[] args) throws Exception {
        TestClass1 t1 = new TestClass1();
        Future<String> completableFuture = t1.calculateAsync();
        if(completableFuture == null) {
            System.out.println("Hello its NULL1");
        }
        String result = completableFuture.get();
        if(result == null) {
            System.out.println("Hello its NULL2");
        } else {
            System.out.println(result);
        }
    }
}


class TestClass1 {
    public Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(5000);

            return "Hello World";
        });

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.schedule(new Callable<Future<String>>(){
            public Future<String> call(){
                try {
                    Thread.sleep(15000);
                    completableFuture.complete("Hello Service call completed");
                } catch(Exception e) {
                    e.printStackTrace();
                }
                return completableFuture;
            }
        }, 10000, TimeUnit.MILLISECONDS);
        executor.shutdownNow();
        return null;
    }

}