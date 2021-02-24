package com.iri.multithreading.concurrentforkjoin;

import com.iri.multithreading.util.ListFillerUtil;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class CallableForkJoiner {
    public int sumSublist() {
        List<Integer> integers = ListFillerUtil.getFilledList();
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        CustomRecursiveTask customRecursiveTask =
                new CustomRecursiveTask(integers, 0, integers.size() - 1);
        return forkJoinPool.invoke(customRecursiveTask);
    }
}
