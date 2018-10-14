package com.jackie.algo.geek.time.chapter5_array;

/**
 * @Author: Jackie
 */
public class ArrayTest {

    public static void main(String[] args) {
        Array array = new Array(10);
        for (int i = 0; i < 8; i++) {
            array.data[i] = i;
        }

        array.count = 8;

        // 打印数组
        array.printArray();

        // 查找
        System.out.println("find result: ");
        System.out.println(array.find(4));

        // 删除
        array.delete(3);
        System.out.println("delete result: ");
        array.printArray();

        // 插入
        array.insert(3, 55);
        System.out.println("insert result: ");
        array.printArray();

        // 在数组最后位置插入
        array.insertToTail(55);
        System.out.println("insertToTail result: ");
        array.printArray();
    }
}
