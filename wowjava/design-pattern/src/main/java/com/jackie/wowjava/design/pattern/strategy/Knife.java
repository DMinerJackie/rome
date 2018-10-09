package com.jackie.wowjava.design.pattern.strategy;

public class Knife extends Role {

    public Knife() {
        weaponBehavior = new SwordBehavior();
    }

    @Override
    void display() {
        System.out.println("我是骑士");
    }
}
