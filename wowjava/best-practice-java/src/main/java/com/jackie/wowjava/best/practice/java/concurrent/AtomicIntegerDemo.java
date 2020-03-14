package com.jackie.wowjava.best.practice.java.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Jackie
 * @date 2018/12/20
 *
 * 主要API
 * public final int get() //获取当前的值
 * public final int getAndSet(int newValue)//获取当前的值，并设置新的值
 * public final int getAndIncrement()//获取当前的值，并自增
 * public final int getAndDecrement() //获取当前的值，并自减
 * public final int getAndAdd(int delta) //获取当前的值，并加上预期的值
 * boolean compareAndSet(int expect, int update) //如果输入的数值等于预期值，则以原子方式将该值设置为输入值（update）
 * public final void lazySet(int newValue)//最终设置为newValue,使用 lazySet 设置之后可能导致其他线程在之后的一小段时间内还是可以读到旧的值。
 */
public class AtomicIntegerDemo {

    public static void main(String[] args) {
        int temValue = 0;
        AtomicInteger value = new AtomicInteger(0);
        temValue = value.getAndSet(3);
        // 首先get，获取到当前value的值为0，并赋值给temValue，之后设置新值3，此时value为3
        System.out.println("temValue = " + temValue + " value = " + value);

        temValue = value.getAndIncrement();
        System.out.println("temValue = " + temValue + " value = " + value);

        temValue = value.getAndDecrement();
        System.out.println("temValue = " + temValue + " value = " + value);

        temValue = value.getAndAdd(10);
        System.out.println("temValue = " + temValue + " value = " + value);
    }
}

/**
 * AtomicInteger 类主要利用 CAS (compare and swap) + volatile 和 native 方法来保证原子操作，
 * 从而避免 synchronized 的高开销，执行效率大为提升。
 *
 * CAS的原理是拿期望的值和原本的一个值作比较，如果相同则更新成新的值。
 * UnSafe 类的 objectFieldOffset() 方法是一个本地方法，这个方法是用来拿到“原来的值”的内存地址，
 * 返回值是 valueOffset。另外 value 是一个volatile变量，在内存中可见，
 * 因此 JVM 可以保证任何时刻任何线程总能拿到该变量的最新值。
 */