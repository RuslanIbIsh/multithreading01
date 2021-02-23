package com.iri.multithreading.service;

import org.apache.log4j.Logger;

public class ImplementingRunnable implements Runnable {
    private static final Logger logger = Logger.getLogger(ImplementingRunnable.class);
    private static final int MAX_COUNT = 100;
    private Counter counter;

    public ImplementingRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getCount() < MAX_COUNT) {
            counter.increment();
            logger.info(Thread.currentThread().getName()
                    + "count = " + counter.getCount() + "\n");
        }
        logger.info("ThreadTwo finished");
    }
}
