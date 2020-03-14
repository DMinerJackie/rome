package com.jackie.wowjava.design.pattern.singleton.classical;

import com.jackie.wowjava.design.pattern.singleton.synchronizedsingleton.SynchronizedSingleton;

import java.util.Optional;

/**
 * 该单例模式是经典的单例模式
 * 在单线程场景下使用没有问题，但是在多线程场景下就可能会出现重复创建ClassicalSingleton实例的情况
 * 一个安全的做法是为getInstance加锁，具体做法见{@link SynchronizedSingleton}
 */
public class ClassicalSingleton {

    private static ClassicalSingleton classicalSingleton = null;

    private ClassicalSingleton() {}

    /**
     * 该方法的方法体可以用Optional改写为更简洁的：
     * return Optional.ofNullable(classicalSingleton).orElse(new ClassicalSingleton());
     * @return
     */
    public static ClassicalSingleton getInstance() {
        if (classicalSingleton == null) {
            classicalSingleton = new ClassicalSingleton();
        }

        return classicalSingleton;
    }
}
