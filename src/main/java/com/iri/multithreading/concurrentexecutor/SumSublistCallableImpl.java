package com.iri.multithreading.concurrentexecutor;

import java.util.List;
import java.util.concurrent.Callable;

public class SumSublistCallableImpl implements Callable<Integer> {
    private List<Integer> integers;

    public SumSublistCallableImpl(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (Integer integer : integers) {
            sum += integer;
        }
        return sum;
    }
}
