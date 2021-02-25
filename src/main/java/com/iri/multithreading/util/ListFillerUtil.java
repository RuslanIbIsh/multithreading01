package com.iri.multithreading.util;

import java.util.ArrayList;
import java.util.List;

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
}
