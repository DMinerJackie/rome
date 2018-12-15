package com.jackie.algo.geek.time.chapter9_queue;

/**
 * @Author: Jackie
 * @date 2018/12/15
 */
public class QueueTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        arrayQueue.enqueue("1");
        arrayQueue.enqueue("2");
        arrayQueue.enqueue("3");

        arrayQueue.printAll();

        arrayQueue.dequeue();

        arrayQueue.printAll();

    }
}
