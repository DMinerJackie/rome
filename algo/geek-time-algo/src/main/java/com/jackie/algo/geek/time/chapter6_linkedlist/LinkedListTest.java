package com.jackie.algo.geek.time.chapter6_linkedlist;

/**
 * @Author: Jackie
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        LinkedList.Node tail = new LinkedList.Node(2, null);
        LinkedList.Node secondNode = new LinkedList.Node(1, tail);
        LinkedList.Node firstNode = new LinkedList.Node(0, secondNode);
        linkedList.setHead(firstNode);

        linkedList.printLinkedList(firstNode);

        // 查找
        System.out.println(linkedList.findByIndex(1));
        System.out.println(linkedList.findByValue(2));

        // 头结点插入
        LinkedList.Node insertNode = linkedList.createNewNode(10);
        linkedList.insertToHead(insertNode);
        linkedList.printLinkedList(insertNode); // insertNode插入为头结点后，在head就是insertNode

        // 某结点后插入
        LinkedList.Node insertAfterNode = linkedList.createNewNode(10);
        linkedList.insertAfter(secondNode, insertAfterNode);
        linkedList.printLinkedList(firstNode);

        // 某结点前插入
        LinkedList.Node insertBeforeNode = linkedList.createNewNode(20);
        linkedList.insertBefore(secondNode, insertBeforeNode);
        linkedList.printLinkedList(firstNode);

        // 删除结点
        linkedList.printLinkedList(firstNode);
        linkedList.deleteByValue(1);
        linkedList.printLinkedList(firstNode);
    }

}
