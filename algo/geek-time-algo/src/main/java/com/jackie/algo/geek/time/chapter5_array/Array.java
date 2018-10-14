package com.jackie.algo.geek.time.chapter5_array;

/**
 * @Author: Jackie
 * @Date: 2018/10/14
 *
 * 数据的插入、删除和查找操作
 */
public class Array {
    // int类型数据
    public int data[];

    // 数组长度
    private int n;

    // 数组实际元素个数
    public int count;

    /**
     * 构造函数，初始化数组
     */
    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0; // 刚开始数组是空的，没有元素，所以是0
    }

    /**
     * 查找元素，主要边界的判定
     */
    public int find(int index) {
        if (index <0 || index >= count)  return -1;
        return data[index];
    }

    /**
     *  删除指定元素
     */
    public boolean delete(int index) {
        if (index < 0 || index >= count) return false;

        for (int i = index; i < count; i++) {
            data[i] = data[i + 1];
        }

        // 删除指定元素后，数组长度减小1
        count--;

        return true;
    }

    /**
     * 插入指定元素
     */
    public boolean insert(int index, int value) {
        if (index < 0 || index > count) return false;   // 支持在任意位置插入元素，如果改为index>=count则不支持在数组最后位置插入

        if (count == n) return false;

        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;

        count++;

        return true;
    }

    /**
     *  在数组最后位置插入元素
     */
    public boolean insertToTail(int value) {
        if (count == n) return false;

        data[count++] = value;
        return true;
    }

    /**
     * 打印数组
     */
    public void printArray() {
        for (int i = 0; i < count; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

}
