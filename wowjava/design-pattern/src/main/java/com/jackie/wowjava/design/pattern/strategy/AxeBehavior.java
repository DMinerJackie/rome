package com.jackie.wowjava.design.pattern.strategy;

public class AxeBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("我使用斧子");
    }
}
