package org.framework.edo.jdk.juc;

import java.util.concurrent.*;

public class MyThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        hanlerString();
    }

    public static void hanlerString() throws ExecutionException, InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        ExecutorService executorService = new ThreadPoolExecutor(3, 5, 5L,
                TimeUnit.SECONDS, blockingQueue, Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 9; i++) {
            int num = i;
            Future<Integer> submit = executorService.submit(() -> {
                Thread.sleep(2000);
                System.out.println("num = " + num);
                return num;
            });
            Integer integer = submit.get();
            System.out.println("integer = " + integer);
        }
    }
}


