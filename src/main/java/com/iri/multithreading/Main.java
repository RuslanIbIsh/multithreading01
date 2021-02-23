package com.iri.multithreading;

import com.iri.multithreading.service.Counter;
import com.iri.multithreading.service.ExtendingThread;
import com.iri.multithreading.service.ImplementingRunnable;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread extendingThread = new ExtendingThread(counter);
        Thread implementingRunnable = new Thread(new ImplementingRunnable(counter));
        extendingThread.start();
        implementingRunnable.start();
    }
}
