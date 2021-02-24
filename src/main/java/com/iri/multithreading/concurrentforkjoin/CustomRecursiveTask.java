package com.iri.multithreading.concurrentforkjoin;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CustomRecursiveTask extends RecursiveTask<Integer> {
    private List<Integer> integers;

    public CustomRecursiveTask(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        for (Integer integer : integers) {
            sum += integer;
        }
        return sum;
    }
}
