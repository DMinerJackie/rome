package com.jackie.wowjava.best.practice.java.concurrent;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Author: Jackie
 * @date 2018/12/20
 *
 * public final int get(int i) //获取 index=i 位置元素的值
 * public final int getAndSet(int i, int newValue)//返回 index=i 位置的当前的值，并将其设置为新值：newValue
 * public final int getAndIncrement(int i)//获取 index=i 位置元素的值，并让该位置的元素自增
 * public final int getAndDecrement(int i) //获取 index=i 位置元素的值，并让该位置的元素自减
 * public final int getAndAdd(int i, int delta) //获取 index=i 位置元素的值，并加上预期的值
 * boolean compareAndSet(int expect, int update) //如果输入的数值等于预期值，则以原子方式将 index=i 位置的元素值设置为输入值（update）
 * public final void lazySet(int i, int newValue)//最终 将index=i 位置的元素设置为newValue,使用 lazySet 设置之后可能导致其他线程在之后的一小段时间内还是可以读到旧的值。
 */
public class AtomicIntegerArrayDemo {

    public static void main(String[] args) {
        int temValue = 0;

        int[] items = {1,2,3,4,5,6,7,8,9,10};
        AtomicIntegerArray array = new AtomicIntegerArray(items);

        for (int i = 0; i < array.length(); i++) {
            System.out.println(array.get(i));
        }

        temValue = array.getAndSet(0, 11);
        System.out.println("temvalue:" + temValue + ";  array:" + array);

        temValue = array.getAndIncrement(1);
        System.out.println("temvalue:" + temValue + ";  array:" + array);

        array.getAndAdd(0, 10);
        System.out.println("temvalue:" + temValue + ";  array:" + array);
    }
}
