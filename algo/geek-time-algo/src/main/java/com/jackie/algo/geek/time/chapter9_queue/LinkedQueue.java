package com.jackie.algo.geek.time.chapter9_queue;

/**
 * @Author: Jackie
 * @date 2018/12/15
 *
 * 基于链表数据结构的队列实现
 * 注意：和基于数据实现的队列{@link ArrayQueue}不同，这里没有n这个参数，
 * 因为基于链表实现是无界的，基于数据实现需要定于数组的大小
 */
public class LinkedQueue {
    // 头指针
    private Node head = null;
    // 尾指针
    private Node tail = null;

    /**
     * 入队
     */
    public void enqueue(String ele) {
        if (head == null) {
            Node node = new Node(ele, null);
            head = node;
            tail = node;
        } else {
            tail.next = new Node(ele, null);
            tail = tail.next;
        }
    }

    /**
     * 出队
     */
    public String dequeue() {
        if (head == null) {
            return null;
        }

        String ret = head.data;
        head = head.next;

        // 如果出队后，头指针head为null，则同时置tail为null
        if (head == null) {
            tail = null;
        }

        return ret;
    }

    public void printAll() {
        Node p = head;

        if (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }

        System.out.println();
    }

    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }
}
