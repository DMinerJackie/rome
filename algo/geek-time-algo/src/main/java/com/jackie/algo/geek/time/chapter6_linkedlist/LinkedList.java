package com.jackie.algo.geek.time.chapter6_linkedlist;

/**
 * @Author: Jackie
 */
public class LinkedList {
    public Node head = null;

    /**
     * 根据指定值查找对应结点
     * @param value
     * @return
     */
    public Node findByValue(int value) {
        Node p = head;

        while(p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    /**
     * 查找指定索引位置的结点
     */
    public Node findByIndex(int index) {
        Node p = head;

        int offset = 0;
        while(p != null && offset != index) {
            p = p.next;
            ++offset;
        }

        return p;
    }

    /**
     * 指定值插入头结点
     */
    public void insertToHead(int value) {
        insertToHead(new Node(value, null));
    }

    /**
     * 指定结点插入头结点
     */
    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     *  在指定结点后插入某值
     */
    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);

        insertAfter(p, newNode);
    }

    /**
     *  在指定结点后插入指定结点
     */
    public void insertAfter(Node p, Node newNode) {
        /**
         * 边界情况考虑
         *  如果p不存在，则不做任何操作
         */
        if (p == null) {
            return;
        }

        newNode.next = p.next;
        p.next = newNode;

    }

    /**
     *
     */
    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    /**
     *
     */
    public void insertBefore(Node p, Node newNode) {
        /**
         * 边界情况考虑
         * 1、如果p为null
         * 2、如果p结点就是head结点
         * 3、没有找到p的前一个结点
         */

        if (p == null) {
            return;
        }

        // 如果p是head结点，即转化为insertToHead方法
        if (head == p) {
            insertToHead(newNode);
            return;
        }

        Node q = head;
        while(q != null && q.next != p) {
            q = q.next;
        }

        // 表示没有找到p结点的前一个结点，所以无法完成插入操作
        if (q == null) {
            return;
        }

        newNode.next = p;
        q.next = newNode;
    }

    /**
     *  删除指定值所在结点
     */
    public void deleteByValue(int value) {
        /**
         * 边界情况考虑
         * 1、空链表
         * 2、遍历查找value所在的结点不存在
         */
        if (head == null) {
            return;
        }

        Node p = head;
        Node q = null;
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }

        if (p == null) {
            return;
        }

        if (q == null) {
            head = head.next;
        } else {
            q.next = p.next;
        }
    }

    /**
     * 删除指定结点
     */
    public void deleteByNode(Node deleteNode) {
        /**
         * 边界情况考虑
         * 1、空链表
         * 2、要删除的结点是空节点
         */
        if (deleteNode == null || head == null) {
            return;
        }

        if (deleteNode == head) {
            head = head.next;
            return;
        }

        Node q = head;
        while(q != null && q.next != deleteNode) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        q.next = q.next.next;
    }

    /**
     *  创建新结点
     */
    public Node createNewNode(int value) {
        return new Node(value, null);
    }

    public void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public static class Node {
        private int data;

        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
