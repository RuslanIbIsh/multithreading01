package com.iri.multithreading.concurrentexecutor;

import com.iri.multithreading.util.ListFillerUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class CallableExecutorTest {
    private static final int EXPECTED_SUM = 1_000_000;
    private CallableExecutor callableExecutor;
    private List<Integer> inputData;

    @Before
    public void setUp() throws Exception {
        callableExecutor = new CallableExecutor();
        inputData = ListFillerUtil.getFilledList();
    }

    @Test
    public void whenExecutorService_expectCorrectSum() {
        Assert.assertEquals(EXPECTED_SUM, callableExecutor.getSumSublist(inputData));
    }
}
