package com.iri.multithreading.concurrentexecutor;

import com.iri.multithreading.util.ListFillerUtil;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExecutor {
    public int getSumSublist() {
        List<Callable<Integer>> listCallable = ListFillerUtil.getCallableLists();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            List<Future<Integer>> futures = executorService.invokeAll(listCallable);
            executorService.shutdown();
            int sumSublist = 0;
            for (Future<Integer> futureIntegerResult : futures) {
                sumSublist += futureIntegerResult.get();
            }
            return sumSublist;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Execution service error", e);
        }
    }
}
