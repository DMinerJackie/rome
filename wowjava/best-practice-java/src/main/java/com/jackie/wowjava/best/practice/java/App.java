package com.jackie.wowjava.best.practice.java;

import java.util.concurrent.locks.ReentrantLock;

public class App {

    public static void main(String[] args) throws Exception {
        final int[] counter = {0};

        ReentrantLock lock = new ReentrantLock();

        for (int i= 0; i < 50; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    try {
                        int a = counter[0];
                        counter[0] = a + 1;
                        System.out.println(counter[0]);

                    }finally {
                        lock.unlock();
                    }
                }
            }).start();
        }

        // 主线程休眠，等待结果
        Thread.sleep(5000);
        System.out.println(counter[0]);
    }
}
