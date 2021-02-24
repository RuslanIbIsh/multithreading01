package com.iri.multithreading.util;

import com.iri.multithreading.concurrentexecutor.SumSublistCallableImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ListFillerUtil {
    public static final int EACH_VALUE = 1;
    private static final int LIST_SIZE = 1_000_000;

    public static List<Integer> getFilledList() {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < LIST_SIZE; i++) {
            integers.add(EACH_VALUE);
        }
        System.out.println(integers.size());
        return integers;
    }

    public static List<Callable<Integer>> getCallableLists() {
        List<Integer> bigDataList = ListFillerUtil.getFilledList();
        List<Callable<Integer>> listCallable = new ArrayList<>();
        listCallable.add(new SumSublistCallableImpl(bigDataList.subList(0, 200_000)));
        listCallable.add(new SumSublistCallableImpl(bigDataList.subList(200_000, 400_000)));
        listCallable.add(new SumSublistCallableImpl(bigDataList.subList(400_000, 600_000)));
        listCallable.add(new SumSublistCallableImpl(bigDataList.subList(600_000, 800_000)));
        listCallable.add(new SumSublistCallableImpl(bigDataList.subList(800_000, 1_000_000)));
        return listCallable;
    }
}
