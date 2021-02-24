package com.iri.multithreading.concurrentforkjoin;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CallableForkJoinerTest {
    private CallableForkJoiner callableForkJoiner;

    @Before
    public void setUp() throws Exception {
    callableForkJoiner = new CallableForkJoiner();
    }

    @Test
    public void wheSumForkJoiner() {
        assertEquals(1000000, callableForkJoiner.sumSublist());
    }
}