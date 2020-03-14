package com.jackie.wowjava.design.pattern.proxy.dynamicproxy;

/**
 * @Author: Jackie
 * @Date: 2018/10/10
 */
public class DynamicProxyDemo {

    public static void main(String[] args) {
        User user = new RealUser();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(user);
        User proxyUser = (User)myInvocationHandler.getProxy();
        proxyUser.request();
    }
}
