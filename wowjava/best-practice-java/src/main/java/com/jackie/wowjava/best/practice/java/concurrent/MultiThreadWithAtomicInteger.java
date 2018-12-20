package com.jackie.wowjava.best.practice.java.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Jackie
 * @date 2018/12/20
 */
public class MultiThreadWithAtomicInteger {

    private AtomicInteger value = new AtomicInteger(0);

    public void count() {
        value.incrementAndGet();
    }

    public int getCount() {
        return value.get();
    }
}
