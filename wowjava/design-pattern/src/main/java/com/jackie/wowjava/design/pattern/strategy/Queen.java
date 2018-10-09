package com.jackie.wowjava.design.pattern.strategy;

public class Queen extends Role {

    public Queen() {
        weaponBehavior = new KnifeBehavior();
    }

    @Override
    void display() {
        System.out.println("我是女王");
    }
}
