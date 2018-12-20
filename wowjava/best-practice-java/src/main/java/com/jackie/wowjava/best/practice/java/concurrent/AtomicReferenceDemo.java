package com.jackie.wowjava.best.practice.java.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: Jackie
 * @date 2018/12/20
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        AtomicReference<Person> personAtomicReference = new AtomicReference<>();
        Person jackie = new Person("Jackie", 18);
        personAtomicReference.set(jackie);

        Person lily = new Person("Lily", 1);
        personAtomicReference.compareAndSet(jackie, lily);
        // 如果personAtomicReference和jackie相等，则设置新值lily，否则维持旧值不变

        System.out.println(personAtomicReference.get().getName());
        System.out.println(personAtomicReference.get().getAge());
    }
}
