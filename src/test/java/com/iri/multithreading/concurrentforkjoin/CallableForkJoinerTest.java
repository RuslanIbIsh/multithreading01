package com.iri.multithreading.concurrentforkjoin;

import com.iri.multithreading.util.ListFillerUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class CallableForkJoinerTest {
    private static final int EXPECTED_SUM = 1_000_000;
    private CallableForkJoiner callableForkJoiner;
    private List<Integer> inputData;

    @Before
    public void setUp() throws Exception {
    callableForkJoiner = new CallableForkJoiner();
    inputData = ListFillerUtil.getFilledList();
    }

    @Test
    public void whenForkJoin_expectCorrectSum() {
        Assert.assertEquals(EXPECTED_SUM, callableForkJoiner.sumSublist(inputData));
    }
}
