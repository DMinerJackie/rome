package com.jackie.wowjava.design.pattern.strategy;

public class King extends Role {

    public King() {
        weaponBehavior = new AxeBehavior();
    }

    @Override
    void display() {
        System.out.println("我是国王");
    }
}
