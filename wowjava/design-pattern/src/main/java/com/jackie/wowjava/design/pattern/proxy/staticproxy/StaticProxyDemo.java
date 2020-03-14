package com.jackie.wowjava.design.pattern.proxy.staticproxy;

/**
 * @Author: Jackie
 * @Date: 2018/10/10
 */
public class StaticProxyDemo {

    public static void main(String[] args) {
        User user = new RealUser();
        User proxyUser = new ProxyUser(user);
        proxyUser.request();
    }
}
