package com.jackie.algo.geek.time.chapter9_queue;

/**
 * @Author: Jackie
 * @date 2018/12/16
 */
public class CircularQueue {

    private String[] items;
    private int n;
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String ele) {
        if ((tail + 1) % n == head) {
            return false;
        }

        items[tail] = ele;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }

        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }

    public void printAll() {
        if (n == 0) {
            return;
        }

        for (int i = head; i % n != tail; i++) {
            System.out.print(items[i] + " ");
        }

        System.out.println();
    }
}
