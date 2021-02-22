package com.iri.multithreading;

import com.iri.multithreading.service.Counter;
import com.iri.multithreading.service.ThreadOne;
import com.iri.multithreading.service.ThreadTwo;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        ThreadOne threadOne = new ThreadOne(counter);
        ThreadTwo threadTwo = new ThreadTwo(counter);
        threadOne.start();
        new Thread(threadTwo).start();
    }
}
