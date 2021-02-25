package com.iri.multithreading.concurrentexecutor;

import com.iri.multithreading.util.ListFillerUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.commons.collections4.ListUtils;

public class CallableExecutor {
    private static final int QUANTITY_THREADS = 5;
    private static final int CHUNK = 200_000;

    public int getSumSublist() {
        List<Callable<Integer>> listCallable = getCallableLists();
        ExecutorService executorService = Executors.newFixedThreadPool(QUANTITY_THREADS);
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

    private List<Callable<Integer>> getCallableLists() {
        List<Integer> bigDataList = ListFillerUtil.getFilledList();
        List<List<Integer>> bigDataSubLists = ListUtils.partition(bigDataList, CHUNK);
        List<Callable<Integer>> listCallable = new ArrayList<>();
        for (List<Integer> integers : bigDataSubLists) {
            listCallable.add(new SumSublistCallableImpl(integers));
        }
        return listCallable;
    }
}
