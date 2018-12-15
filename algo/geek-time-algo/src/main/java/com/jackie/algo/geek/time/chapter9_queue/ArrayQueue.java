package com.jackie.algo.geek.time.chapter9_queue;

/**
 * @Author: Jackie
 * @date 2018/12/15
 *
 * 基于数组数据结构的队列实现
 */
public class ArrayQueue {

    // 数组items
    private String[] items;
    // 数组大小
    private int n = 0;
    // 数组头下标
    private int head = 0;
    // 数组尾下标
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     */
    public boolean enqueue(String ele) {
        // 队列满了
        if (tail == n) {
            return false;
        }

        items[tail++] = ele;
        return true;
    }

    /**
     * 出队
     */
    public String dequeue() {
        if (head == tail) {
            return null;
        }

        return items[head++];
    }

    /**
     * 打印所有队列元素
     */
    public void printAll() {
        for (int i = head; i < tail; i++) {
            System.out.print(items[i] + " ");
        }

        System.out.println();
    }
}
