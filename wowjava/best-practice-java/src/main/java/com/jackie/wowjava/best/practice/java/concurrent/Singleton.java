package com.jackie.wowjava.best.practice.java.concurrent;

/**
 * @Author: Jackie
 * @date 2019/1/10
 * synchronized在1.6之前的版本性能很低，从1.6优化之后效率提高很多。
 * 可以修饰方法、实例和类
 */
public class Singleton {
    private static Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }
}
