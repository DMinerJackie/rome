package com.jackie.wowjava.best.practice.java.optional;

import com.jackie.wowjava.best.practice.java.model.Person;

import java.util.Optional;

public class OptionalPractice {

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(18);
        person.setName("jackie");

        usageWithoutOptional(person);
        usageWithOptional(person);

        // 总结，orElse和orElseThrow就是==null的情况，ifPresent就是!=null的情况，
        // isPresent是用于判断是否为空的情况，等价于if（xxx != null）
        // 流式调用还是lambda表达式那一套
    }

    private static void usageWithOptional(Person person) {
        int age = -1;
        if (person != null) {
            if (person.getAge() != null) {
                age = person.getAge();
            }
        } else {
            age = 0;
        }

        System.out.println(age);

        //============================
        if (person.getAge() != null) {
            person.setAge(person.getAge());
        } else {
            person.setAge(-1);
        }


    }

    private static void usageWithoutOptional(Person person) {
        System.out.println(Optional.ofNullable(person).filter(person1 -> person1.getAge() != null)
                .map(Person::getAge).orElse(0));

        // 不推荐，因为使用isPresent有存在null的风险，违背使用Optional的初衷
        System.out.println(Optional.ofNullable(person).filter(p -> Optional.ofNullable(p.getAge()).isPresent())
                .map(Person::getAge).orElse(0));

        //============================
        person.setAge(Optional.ofNullable(person).map(Person::getAge).orElse(-1));
    }

}
