package com.iri.multithreading.concurrentforkjoin;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CustomRecursiveTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 200_000;
    private List<Integer> integers;
    private int start;
    private int end;

    public CustomRecursiveTask(List<Integer> integers, int start, int end) {
        this.integers = integers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end - start) > THRESHOLD) {
            int half = (start + end) / 2;
            CustomRecursiveTask firstHalf = new CustomRecursiveTask(integers, start, half);
            CustomRecursiveTask secondHalf = new CustomRecursiveTask(integers, half + 1, end);
            firstHalf.fork();
            Integer secondHalfComputation = secondHalf.compute();
            Integer firstHalfComputation = firstHalf.join();
            return firstHalfComputation + secondHalfComputation;
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += integers.get(i);
        }
        return sum;
    }
}
