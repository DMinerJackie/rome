package com.jackie.wowjava.design.pattern.strategy;

public abstract class Role {

    WeaponBehavior weaponBehavior;

    public Role() {

    }

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    abstract void display();

    public void weaponWay() {
        weaponBehavior.useWeapon();
    }
}
