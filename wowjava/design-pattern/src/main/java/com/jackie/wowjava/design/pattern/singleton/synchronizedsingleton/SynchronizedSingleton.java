package com.jackie.wowjava.design.pattern.singleton.synchronizedsingleton;

import com.jackie.wowjava.design.pattern.singleton.preinitialization.PreInitializationSingleton;

/**
 * 该单例模式采用在getInstance方法上加锁，但是多线程场景下，同一时间只能有一个线程可以进入，其他线程都将阻塞，降低了并发效率
 * 所以，可以考虑如果是多线程的场景下，我们在一开始就提供一份SynchronizedSingleton实例
 * 具体做法见{@link PreInitializationSingleton}
 */
public class SynchronizedSingleton {

    private static SynchronizedSingleton synchronizedSingleton = null;

    private SynchronizedSingleton() {}

    public static synchronized SynchronizedSingleton getInstance() {
        if (synchronizedSingleton == null) {
            synchronizedSingleton = new SynchronizedSingleton();
        }

        return synchronizedSingleton;
    }
}
