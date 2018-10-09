package com.jackie.wowjava.design.pattern.strategy;

public class Troll extends Role {

    public Troll() {
        weaponBehavior = new SwordBehavior();
    }

    @Override
    void display() {
        System.out.println("我是妖怪");
    }
}
