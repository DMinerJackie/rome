package com.jackie.wowjava.design.pattern.proxy.staticproxy;

/**
 * @Author: Jackie
 * @Date: 2018/10/10
 */
public class ProxyUser implements User {
    private User user;

    public ProxyUser(User user) {
        this.user = user;
    }


    @Override
    public void request() {
        System.out.println("before call method");
        user.request();
        System.out.println("after call method");
    }
}
