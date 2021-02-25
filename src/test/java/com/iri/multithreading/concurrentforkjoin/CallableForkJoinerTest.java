package com.iri.multithreading.concurrentforkjoin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CallableForkJoinerTest {
    private static final int EXPECTED_SUM = 1_000_000;
    private CallableForkJoiner callableForkJoiner;

    @Before
    public void setUp() throws Exception {
    callableForkJoiner = new CallableForkJoiner();
    }

    @Test
    public void whenForkJoin_expectCorrectSum() {
        Assert.assertEquals(EXPECTED_SUM, callableForkJoiner.sumSublist());
    }
}
