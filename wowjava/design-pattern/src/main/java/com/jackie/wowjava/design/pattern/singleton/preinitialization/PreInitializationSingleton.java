package com.jackie.wowjava.design.pattern.singleton.preinitialization;

import com.jackie.wowjava.design.pattern.singleton.doublechecklock.DoubleCheckLockSingleton;

/**
 * 该单例模式采用预初始化的方式，因为使用static修饰，所以类一旦加载，就会生成一份PreInitializationSingleton实例
 * 这样即使是多线程场景，每次取到的都只能是同一份实例
 * 但是，该方式每次都会创建实例，不是很优雅，更加优雅的做法见{@link DoubleCheckLockSingleton}
 */
public class PreInitializationSingleton {
    private static PreInitializationSingleton preInitializationSingleton = new PreInitializationSingleton();

    private PreInitializationSingleton() {}

    public static PreInitializationSingleton getInstance() {

        return new PreInitializationSingleton();
    }
}
