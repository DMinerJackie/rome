package com.jackie.wowjava.design.pattern.proxy.staticproxy;

/**
 * @Author: Jackie
 * @Date: 2018/10/10
 */
public class RealUser implements User {
    @Override
    public void request() {
        System.out.println("I am real user");
    }
}
