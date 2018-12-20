package com.jackie.wowjava.best.practice.java.concurrent;

/**
 * @Author: Jackie
 * @date 2018/12/20
 */
public class MutilThreadWithoutAtomicInteger {

    private volatile int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
