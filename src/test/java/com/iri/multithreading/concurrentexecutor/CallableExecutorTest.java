package com.iri.multithreading.concurrentexecutor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CallableExecutorTest {
    private static final int EXPECTED_SUM = 1_000_000;
    private CallableExecutor callableExecutor;

    @Before
    public void setUp() throws Exception {
        callableExecutor = new CallableExecutor();
    }

    @Test
    public void whenExecutorService_expectCorrectSum() {
        Assert.assertEquals(EXPECTED_SUM, callableExecutor.getSumSublist());
    }
}
