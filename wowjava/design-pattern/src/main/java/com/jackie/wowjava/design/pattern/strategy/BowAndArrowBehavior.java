package com.jackie.wowjava.design.pattern.strategy;

public class BowAndArrowBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("我使用🏹");
    }
}
