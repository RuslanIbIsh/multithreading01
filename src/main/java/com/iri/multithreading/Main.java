package com.iri.multithreading;

import com.iri.multithreading.concurrentforkjoin.CallableForkJoiner;

public class Main {
    public static void main(String[] args) {
        /*Counter counter = new Counter();
        Thread extendingThread = new ExtendingThread(counter);
        Thread implementingRunnable = new Thread(new ImplementingRunnable(counter));
        extendingThread.start();
        implementingRunnable.start();
        */

        /*CallableExecutor callableExecutor = new CallableExecutor();
        System.out.println(callableExecutor.getSumSublist());
        */

        CallableForkJoiner callableForkJoiner = new CallableForkJoiner();
        System.out.println(callableForkJoiner.sumSublist());

    }
}
