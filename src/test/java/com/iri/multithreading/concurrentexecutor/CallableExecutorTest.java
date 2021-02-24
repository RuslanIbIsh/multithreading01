package com.iri.multithreading.concurrentexecutor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CallableExecutorTest {
    private CallableExecutor callableExecutor;

    @Before
    public void setUp() throws Exception {
        callableExecutor = new CallableExecutor();
    }

    @Test
    public void whenSum() {
        assertEquals(1000000, callableExecutor.getSumSublist());
    }
}