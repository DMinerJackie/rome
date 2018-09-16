package com.jackie.wowjava.design.pattern.singleton.doublechecklock;

/**
 * 双重检查锁机制相较于直接在getInstance上加锁，效率更高
 * 首先判定实例是否为null，如果为null，这时候需要获取锁，拿到锁后再次判定实例是否为null
 * 如果不为null，才最终创建实例
 * 第二个判空是为了防止有两个进程几乎同时进入，如果前一个执行完，第二个进程直接获得锁，如果没有判空条件，则会直接创建一个实例
 */
public class DoubleCheckLockSingleton {

    private static DoubleCheckLockSingleton doubleCheckLockSingleton = null;

    private DoubleCheckLockSingleton() {}

    /**
     * 这里为什么有两个判空的语句，分别有什么用处
     * 参见该项目中README.md的参考链接 https://blog.csdn.net/shallynever/article/details/52503139
     */
    public static DoubleCheckLockSingleton getInstance() {
        if (doubleCheckLockSingleton == null) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (doubleCheckLockSingleton == null) {
                    doubleCheckLockSingleton = new DoubleCheckLockSingleton();
                }
            }
        }
        return doubleCheckLockSingleton;
    }
}
