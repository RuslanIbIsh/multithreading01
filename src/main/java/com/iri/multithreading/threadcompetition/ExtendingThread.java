package com.iri.multithreading.threadcompetition;

import org.apache.log4j.Logger;

public class ExtendingThread extends Thread {
    private static final Logger logger = Logger.getLogger(ExtendingThread.class);
    private static final int MAX_COUNT = 100;
    private Counter counter;

    public ExtendingThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getCount() < MAX_COUNT) {
            counter.increment();
            logger.info(Thread.currentThread().getName() + "count = "
                    + counter.getCount() + "\n");
        }
        logger.info("ThreadOne finished");
    }
}
