package com.jackie.wowjava.design.pattern.strategy;

public class StrategyTest {
    public static void main(String[] args) {
        King king = new King();
        king.display();
        king.weaponWay();
        System.out.println("更换武器^");
        king.setWeaponBehavior(new SwordBehavior());
        king.weaponWay();
        System.out.println("……………………………………………………………………………………");
    }


}
